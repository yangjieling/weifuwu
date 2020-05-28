package com.xiaoxin.spring.common.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseEntity<T> implements Serializable {

    private static final long serialVersionUID = -4870392286955743072L;

    private ResponseHead head;
    private T body;
}
