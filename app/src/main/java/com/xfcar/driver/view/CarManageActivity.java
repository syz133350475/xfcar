package com.xfcar.driver.view;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.xfcar.driver.R;
import com.xfcar.driver.model.bean.Command;
import com.xfcar.driver.model.viewbean.FunctionBean;
import com.xfcar.driver.mvp.BaseActivity;
import com.xfcar.driver.view.adapter.FunctionAdapter;

import rx.functions.Action1;

/**
 * @author linky
 */
public class CarManageActivity extends BaseActivity {

    private RecyclerView mRvFunction;
    private FunctionAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_manage);
        initView();
    }

    private void initView() {

        TextView tv = findViewById(R.id.tv_title);
        tv.setText("车辆管理");

        findViewById(R.id.iv_return_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mRvFunction = findViewById(R.id.rv_car_function);
        mRvFunction.setLayoutManager(new GridLayoutManager(this, 3));
        mAdapter = new FunctionAdapter(this);
        mAdapter.setCallback(new Action1<FunctionBean>() {
            @Override
            public void call(FunctionBean appBean) {

                switch (appBean.name) {
                    case "车辆信息":
                        startActivity(CarListInfoActivity.class);
                        break;
                    case "一键开门":
                        Bundle bundle = new Bundle();
                        bundle.putString("CMD_OPERATE", Command.SN_SAFEOFF);
                        startActivity(CarOperateActivity.class, bundle);
                        break;
                    case "一键上锁":
                        bundle = new Bundle();
                        bundle.putString("CMD_OPERATE", Command.SN_SAFEON);
                        startActivity(CarOperateActivity.class, bundle);
                        break;
                    case "蓝牙钥匙":
                        startActivity(BluetoothKeyActivity.class);
                        break;
                    case "位置":
                        startActivity(CarPositionActivity.class);
                        break;
                    case "理赔":
                        startActivity(ClaimPayListActivity.class);
                        break;
                    case "维修":
                        startActivity(RepairListActivity.class);
                        break;
                    case "车辆安全":
                        startActivity(CarSecurityActivity.class);
                        break;
                }
        }});

        mRvFunction.setAdapter(mAdapter);
        mAdapter.setData(FunctionBean.mockCarFuncBeans());
    }

}