package com.device.limaiyun.thingsboard.ui.activity.childactivity.equipment.presenter;

import com.device.limaiyun.thingsboard.base.BasePresenter;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.equipment.model.EquipmentPort;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.equipment.view.EquipmentView;

/**
 * Created by Administrator on 2018/5/10 0010.
 */

public class EquipmentPresenter extends BasePresenter {
    private EquipmentView mEquipmentView;
    private EquipmentPort mEquipmentPort;

    public EquipmentPresenter(EquipmentView equipmentView) {
        this.mEquipmentView = equipmentView;
    }




}
