package com.wangteng.file;

import lombok.Builder;
import lombok.Data;

/**
 * @author wangteng
 * @version 1.0
 * @description TODO
 * @date 2020/6/9 15:12
 */
@Data
@Builder
public class FileInfoVO {
    String fileName;
    long fileSize;
}
