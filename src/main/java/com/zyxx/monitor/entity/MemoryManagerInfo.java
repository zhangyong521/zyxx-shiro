package com.zyxx.monitor.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.management.ObjectName;

/**
 * vm内存管理器
 *
 * @author Tellsea
 * @date 2020-6-16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class MemoryManagerInfo {

    private String managerName;
    private String managerMemoryPoolNames;
    private ObjectName managerObjectName;
}
