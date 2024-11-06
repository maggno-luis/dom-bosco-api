package br.com.dev.api_service.controller;

import br.com.dev.api_service.domain.Called;
import br.com.dev.api_service.domain.dtos.CalledResponseDto;
import br.com.dev.api_service.domain.dtos.CreateCallRequestDto;
import br.com.dev.api_service.service.CalledService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/called")
@CrossOrigin("*")
public class CalledController {
    
    private final CalledService calledService;
    @Autowired
    public CalledController(CalledService calledService ) {
        this.calledService = calledService;
    }

    @Operation(description = "Faz o registro do chamado")
    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?> create(@RequestBody CreateCallRequestDto createCallRequestDto) {
        return ResponseEntity.ok(calledService.create(createCallRequestDto));
    }

    @Operation(description = "Lista todos os chamados criados, mas somentes ADMIN E SUPER_ADMIN podem fazer a requisição")
    @GetMapping("/listAll")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    public ResponseEntity<Page<CalledResponseDto>> listAll(@RequestParam(defaultValue = "0") int page,
                                           @RequestParam(defaultValue = "10") int size){
        return ResponseEntity.ok(calledService.listAll(page,size));
    }

    @Operation(description = "Lista todos chamados realizado pelo usuario que está logado")
    @GetMapping("/listMy")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Page<CalledResponseDto>> listMyCalls(@RequestParam(defaultValue = "0") int page,
                                                    @RequestParam(defaultValue = "10") int size){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return ResponseEntity.ok(calledService.listMyCalling(email, page, size));
    }

    @Operation(description = "Método responsável por atualizar o status do chamado para RESOLVIDO")
    @PutMapping("/{id}/status")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    public ResponseEntity<CalledResponseDto> updateCallStatus(@PathVariable Long id){
        return ResponseEntity.ok(calledService.updateCallStatus(id));
    }

}
