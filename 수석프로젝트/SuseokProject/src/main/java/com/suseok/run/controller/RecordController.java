package com.suseok.run.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/record")
@Tag(name="RecordRestController", description = "기록CRUD")
public class RecordController {

}
