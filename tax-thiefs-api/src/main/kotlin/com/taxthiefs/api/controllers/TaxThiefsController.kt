package com.taxthiefs.api.controllers

import com.taxthiefs.api.application.ThiefService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TaxThiefsController {
    @Autowired
    private lateinit var thiefService: ThiefService

    @GetMapping("/thiefs")
    fun getThiefs() = thiefService.getThiefs()
}
