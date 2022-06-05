package com.spring.cruddemo.repository;

import com.spring.cruddemo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    //custom methods
    Department findByDepartmentName(String departmentName);
    Department findByDepartmentNameIgnoreCase(String departmentName);

    //custom JPQL query method
    @Query("select d from Department d where d.departmentCode=?1")
    Department findByDepartmentCodeJPQL(String departmentCode);

    //custom NSQL (NativeSQL) query method
    // (NOTE: use _ 'underscore' in the field name as we used camel case in the entity,
    // else use @Column(name="") with value all lower case, the resulting coulum will be created without _
    @Query(value = "select * from Department d where d.department_Code=?1", nativeQuery = true)
    Department findByDepartmentCodeNSQL(String departmentCode);
}
