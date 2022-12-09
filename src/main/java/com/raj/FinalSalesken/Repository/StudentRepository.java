package com.raj.FinalSalesken.Repository;


import com.raj.FinalSalesken.Model.Student;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/*
 * Allows to create repositories for writing simple CRUD methods.
 * ElasticsearchRestTemplate should be used in order to have more control over the queries
 * */
@Repository
public interface StudentRepository extends ElasticsearchRepository<Student, String> {
}