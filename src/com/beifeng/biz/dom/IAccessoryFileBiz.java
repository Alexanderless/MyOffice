package com.beifeng.biz.dom;

import java.util.List;

import com.beifeng.model.AccessoryFile;

public interface IAccessoryFileBiz {
	List<AccessoryFile> queryByFiledid(Integer fileId);

}
