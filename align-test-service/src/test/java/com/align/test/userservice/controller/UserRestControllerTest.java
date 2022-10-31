package com.align.test.userservice.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.align.test.userservice.entity.User;
import com.align.test.userservice.service.UserService;

@RunWith(SpringRunner.class)
public class UserRestControllerTest {
	
	
	@InjectMocks
    UserRestController userRestController;

    @Mock
    UserService userService;

    @Test
    public void testAddUser(){
        /*User user = prepareUserObject();
        Mockito.when(userService.addUser(user)).thenReturn(prepareUserResponseObject());
        User userRes = userRestController.addUser(user);
        assertEquals(45, userRes.getId());
        assertEquals("Alex", userRes.getUserName());*/
       
    }

}
