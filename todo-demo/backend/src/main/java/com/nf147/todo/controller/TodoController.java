package com.nf147.todo.controller;

import com.nf147.todo.entity.Todo;
import com.nf147.todo.mapper.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
@CrossOrigin
public class TodoController {

    @Autowired
    private TodoMapper todoMapper;
    @RequestMapping(method = RequestMethod.GET)
    public List<Todo> home () {

        return todoMapper.getTodos();
    }
    @RequestMapping(method = RequestMethod.POST)
    public int add (@RequestBody Todo todo) {
        return todoMapper.addTodo(todo);
    }
    @RequestMapping(value = "/del",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String del (  int id) {
        if(todoMapper.deleteTodo(id)>0)
        return  "\"msg\":\"删除成功\"";
        else
            return  "\"msg\":\"删除失败\"";
    }
    @RequestMapping(value = "/upda",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String makeDone ( int id) {
            Todo todo=todoMapper.getTodo(id);
            if(todo.getState().equals("完成")){
                if(todoMapper.makeCancle(id)>0)
                    return  "\"msg\":\"修改成功\"";
                    else {
                    return  "\"msg\":\"修改失败\"";
                }
            }else {
                if(todoMapper.makeDone(id)>0)
                    return  "\"msg\":\"修改成功\"";
                else {
                    return  "\"msg\":\"修改失败\"";
                }
            }
    }
}
