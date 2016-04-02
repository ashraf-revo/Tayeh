package org.revo.controller

import com.fasterxml.jackson.annotation.JsonView
import groovy.util.logging.Log
import org.revo.Service.ChildService
import org.revo.Service.LoggerService
import org.revo.Service.SecurityService
import org.revo.Util.RevoView
import org.revo.domain.Child
import org.revo.model.ErrorMessage
import org.revo.model.SearchCriteria
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * Created by ashraf on 12/4/2015.
 */
@RestController
@RequestMapping(value = "/api")
@Log
class ApiCtrl {
    @Autowired
    SecurityService securityService
    @Autowired
    LoggerService loggerService
    @Autowired
    ChildService childService


    @RequestMapping(value = "account", method = RequestMethod.GET)
    @ResponseBody
    def getAccount() {
        try {
            ResponseEntity.ok(securityService.GetRevoUser())
        } catch (Exception ignored) {
            new ResponseEntity<>(HttpStatus.UNAUTHORIZED)
        }
    }

    @JsonView(RevoView.ChildAndItsPerson.class)
    @RequestMapping(value = "/searchcriteria", method = RequestMethod.POST)
    @ResponseBody
    def Search(@RequestBody SearchCriteria criteria) {
        try {
            ResponseEntity.ok(childService.search(criteria))
        } catch (Exception ignored) {
            loggerService.Error(log, new ErrorMessage(1, ignored.message))
        }
    }

    @RequestMapping(value = "/uplode", method = RequestMethod.POST)
    @ResponseBody
    def uplode(@RequestBody Child child) {
        try {
            childService.uplode(child)
            new ResponseEntity(HttpStatus.NO_CONTENT)
        } catch (Exception ignored) {
            loggerService.Error(log, new ErrorMessage(1, ignored.message))
        }
    }

    @JsonView(RevoView.SuggestedAndChildAndItsPerson.class)
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    def SearchImage(@RequestBody Child c) {
        try {
            ResponseEntity.ok(childService.search(c))
        } catch (Exception ignored) {
            loggerService.Error(log, new ErrorMessage(1, ignored.message))
        }
    }

    @JsonView(RevoView.ChildAndItsPerson.class)
    @RequestMapping(value = "/images", method = RequestMethod.GET)
    @ResponseBody
    def Images() {
        try {
            ResponseEntity.ok(childService.findAll(securityService.GetRevoUser().id))
        } catch (Exception ignored) {
            loggerService.Error(log, new ErrorMessage(1, ignored.message))
        }
    }

    @JsonView(RevoView.ChildAndItsPerson.class)
    @RequestMapping(value = "/imageinfo/{id}", method = RequestMethod.GET)
    @ResponseBody
    def ImageInfo(@PathVariable("id") String id) {
        try {
            ResponseEntity.ok(childService.findOne(id))
        } catch (Exception ignored) {
            loggerService.Error(log, new ErrorMessage(1, ignored.message))
        }
    }
}
