package com.learnmonilithic.payload.request;

import lombok.Data;

@Data
public class PaginationRequest {
    private int pageNumber;
    private int pageSize;
}
