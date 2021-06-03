package com.laba1.laba1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
public class GreetingController {

    private final AtomicLong counter = new AtomicLong();
    @Autowired
    private  Cache cache;
    @Autowired
    private Counter requestCounter;
    String key;

    //@Autowired
    //private DataBaseRepository dataBaseRepository;



    @GetMapping("/greeting")

    public ResponseEntity <Greeting> greeting(@RequestParam(value = "mas1", defaultValue = "1") String inputMas1,
                             @RequestParam(value = "mas2", defaultValue = "1") String inputMas2,
                             @RequestParam(value = "speed1", defaultValue = "0") String inputSpeed1,
                             @RequestParam(value = "speed2", defaultValue = "0") String inputSpeed2) {
        requestCounter.incrementCounter();                                        //Инкрементация счётчика запросов
        log.info("Counter: " + requestCounter.getCounter());

            key= inputMas1 + " " + inputMas2 + " " + inputSpeed1 + " " + inputSpeed2;
            if(cache.searchKey(key)){
                log.info(key);
                log.info("Key repeat!");
                return ResponseEntity.ok(cache.getValume(key));
            }


        List<String> masParam = new ArrayList<String>();
        masParam.add(inputMas1);
        masParam.add(inputMas2);

        List<String> speedParam = new ArrayList<String>();
        speedParam.add(inputSpeed1);
        speedParam.add(inputSpeed2);



        List<Integer> parmas = masParam.stream()
                .map(ValidateFunction::validateMas)
                .collect(Collectors.toList());
        List<Integer> parspeed = speedParam.stream()
                .map(ValidateFunction::validateSpeed)
                .collect(Collectors.toList());


            int mas1 = parmas.get(0);
            int mas2 = parmas.get(1);
            int speed1 = parspeed.get(0);
            int speed2 = parspeed.get(1);

            Greeting object = new Greeting(mas1,mas2,speed1,speed2);
            cache.addCacheObject(key,object);
            //object.setMin(MinMaxAverage.callMin(cache));
            //object.setMax(MinMaxAverage.callMax(cache));
           // object.setAverage(MinMaxAverage.callAverage(cache));
            ;
            log.info("Key = "+key);
            log.info("Data in cache: " + cache.toString() );

            return ResponseEntity.ok(object);


    }

    @PostMapping(path = "/post", consumes = "application/json", produces = "application/json")
    public synchronized ResponseEntity<List<Greeting>> greeting(@RequestBody List<GreetingString> objects) { // СДЕЛАТЬ СПИСОК  И ВЫВЕСТИ МИНИМАЛЬНЫЕ ЗН. И ТД.
        log.info("Objs received ");
        int i;
        requestCounter.incrementCounter();                                        //Инкрементация счётчика запросов
        log.info("Counter: " + requestCounter.getCounter());


        List<Greeting> objlist = objects.stream()
                .map(ValidateFunction::validateObject)
                .collect(Collectors.toList());

       // for (i=0;i<objlist.size();i++) {
            //Greeting test = objlist.get(i);
            //dataBaseRepository.save(test);
        //}


        return ResponseEntity.ok(objlist);
    }
}


