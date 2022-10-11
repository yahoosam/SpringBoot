package com.curiousbinary.graphqldemo.service;

import com.curiousbinary.graphqldemo.entity.Department;
import com.curiousbinary.graphqldemo.repository.DepartmentRepository;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.DataFetcher;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class DepartmentGraphQLServiceImpl implements DepartmentGraphQLService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Value("classpath:department.graphqls")
    private Resource schemaResource;

    private GraphQL graphQL;

    @PostConstruct
    public void loadSchema() throws IOException {
        File schemaFile = schemaResource.getFile();
        TypeDefinitionRegistry registry = new SchemaParser().parse(schemaFile);
        RuntimeWiring wiring = buildWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(registry, wiring);
        graphQL = GraphQL.newGraphQL(schema).build();
    }

    private RuntimeWiring buildWiring() {
        DataFetcher<List<Department>> alldepartmentfetcher = (data) -> departmentRepository.findAll();

        DataFetcher<Department> departmentfetcher = (data) -> departmentRepository.findById(data.getArgument("departmentId")).get();

        return RuntimeWiring.newRuntimeWiring().type("Query", (typewriting) -> typewriting
                        .dataFetcher("getAllDepartments", alldepartmentfetcher)
                        .dataFetcher("getDepartment", departmentfetcher))
                .build();
    }

    @Override
    public ResponseEntity<Object> getDepartmentList(String query) {
        ExecutionResult result = graphQL.execute(query);
        return new ResponseEntity<Object>(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> getDepartment(String query) {
        ExecutionResult result = graphQL.execute(query);
        return new ResponseEntity<Object>(result, HttpStatus.OK);
    }
}
