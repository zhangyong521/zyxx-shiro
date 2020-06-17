package com.zyxx.filetree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Tellsea
 * @date 2020-6-3
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tree {
    private Integer id;
    private String name;//文件夹或者文件名称
    private String path;//全路径,或则部分路径,自己决定
    private Integer parentId;//父节点id
}
