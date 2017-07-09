package net.leebao.busi.controller;

import net.leebao.busi.entity.Train;
import net.leebao.core.commons.PageParam;
import net.leebao.busi.service.TrainService;
import net.leebao.core.exception.LeeBaoException;
import net.leebao.core.commons.Pageable;
import net.leebao.core.commons.Success;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhuxl@paxsz.com on 2016/7/27.
 */
@SuppressWarnings("ALL")
@Controller
@RequestMapping(value = "/api/v1/train")
public class TrainController {
    private static final Logger logger = LoggerFactory.getLogger(TrainController.class);

    @Autowired
    private TrainService trainService;

    @RequestMapping(value = "save", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity add(@RequestBody Train train) {
        try {
            trainService.addTrain(train);
            Success ok = new Success("添加成功", "恭喜你!添加成功");
            return new ResponseEntity(ok, HttpStatus.OK);
        } catch (LeeBaoException e) {
            return new ResponseEntity(e, HttpStatus.BAD_REQUEST);
        }
    }


    @RequestMapping(value = "list", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity pagelist(@RequestBody PageParam pageParam) {
        try {
            Pageable pageable = trainService.trainList(pageParam);
            Success ok = new Success(pageable, "查询成功");
            return new ResponseEntity(ok, HttpStatus.OK);
        } catch (LeeBaoException e) {
            return new ResponseEntity(e, HttpStatus.BAD_REQUEST);
        }
    }
}
