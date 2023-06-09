package com.uiktp.finki.ukim.fluidlearning.Web;


import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Course;
import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Exam;
import com.uiktp.finki.ukim.fluidlearning.Models.dto.CourseDto;
import com.uiktp.finki.ukim.fluidlearning.Models.dto.CourseWithIdDto;
import com.uiktp.finki.ukim.fluidlearning.Models.dto.ExamWithIdDto;
import com.uiktp.finki.ukim.fluidlearning.Service.CourseService;
import com.uiktp.finki.ukim.fluidlearning.Service.Course_UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
@CrossOrigin(value = "*")
public class CourseRestController {

    private final CourseService courseService;
    private final Course_UserService course_userService;
    private final ModelMapper modelMapper;

    public CourseRestController(CourseService courseService, Course_UserService course_userService, ModelMapper modelMapper) {
        this.courseService = courseService;
        this.course_userService = course_userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<Course> findAll() {
        return this.courseService.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Course> findById(@PathVariable Integer id) {
        return this.courseService.findById(id)
                .map(course -> ResponseEntity.ok().body(course)).orElseGet(() -> ResponseEntity.badRequest().build());
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

    @GetMapping("/exams/{courseUserId}")
    public ResponseEntity<List<ExamWithIdDto>> getAllExamsForCourse(@PathVariable Integer courseUserId) {

        List<Exam> exams = course_userService.getAllExamsByCourseUserId(courseUserId);

        List<ExamWithIdDto> examDtos = exams.stream()
                .map(e -> modelMapper.map(e, ExamWithIdDto.class))
                .toList();

        return ResponseEntity.ok(examDtos);
    }
}
