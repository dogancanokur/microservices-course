package net.okur.productservice.dto.output;

import lombok.Data;

/**
 * @author dogancan.okur
 * 10.12.2022 00:36
 */
@Data
public class ServiceOutput {
    private String message;
    private ServiceOutput.Status status;

    public enum Status {
        SUCCESS, ERROR
    }
}
