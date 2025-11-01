package com.khazan.appointment.system.controller.sse;

import com.khazan.appointment.system.service.sse.SseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RequiredArgsConstructor
@RestController
@RequestMapping("/sse")
public class SseController {

    private final SseService sseService;

    @GetMapping("/subscribe/{clientId}")
    public SseEmitter subscribe(@PathVariable String clientId) {
        return sseService.subscribe(clientId);
    }

    @DeleteMapping("/unsubscribe/{clientId}")
    public void unsubscribe(@PathVariable String clientId) {
        sseService.unsubscribe(clientId);
    }

    @PostMapping("/send")
    public void sendMessage(@RequestParam String message) {
        sseService.sendMessageToAll(message);
    }
}
