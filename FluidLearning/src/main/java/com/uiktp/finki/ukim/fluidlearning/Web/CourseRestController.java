package com.uiktp.finki.ukim.fluidlearning.Web;


import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Course;
import com.uiktp.finki.ukim.fluidlearning.Models.dto.CourseDto;
import com.uiktp.finki.ukim.fluidlearning.Service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/course")
@CrossOrigin(value = "*")
public class CourseRestController {

    private final CourseService courseService;

    public CourseRestController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> findAll() {
        return this.courseService.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Course> findById(@PathVariable Integer id) {
        return this.courseService.findById(id).map(course -> ResponseEntity.ok().body(course)).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/add")
    public ResponseEntity<CourseDto> save(@RequestBody CourseDto courseDto) {
        CourseDto courseDto1 = this.courseService.save(courseDto);
        return ResponseEntity.ok().body(courseDto1);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<CourseDto> edit(@PathVariable Integer id, @RequestBody CourseDto courseDto) {
        CourseDto courseDto1 = this.courseService.edit(id, courseDto);
        return ResponseEntity.ok().body(courseDto1);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        this.courseService.deleteById(id);
        if (this.courseService.findById(id).isEmpty())
            return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }


}