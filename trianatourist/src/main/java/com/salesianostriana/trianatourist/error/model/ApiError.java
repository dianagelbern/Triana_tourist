package com.salesianostriana.trianatourist.error.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiError {

    private HttpStatus estado;
    private int codigo;
    private String mensaje;
    private String ruta;

    @Builder.Default
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime fecha = LocalDateTime.now();

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ApiSubError> subErrors;

    public ApiError(HttpStatus estado, int codigo, String mensaje, String ruta, LocalDateTime fecha) {
        this.estado = estado;
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.ruta = ruta;
        this.fecha = fecha;
    }

    public ApiError(HttpStatus estado, String mensaje, String ruta, List<ApiSubError> subErrors) {
        this.estado = estado;
        this.mensaje = mensaje;
        this.ruta = ruta;
        this.subErrors = subErrors;
    }

    public ApiError(HttpStatus status, String message, String requestURI) {
    }
}
