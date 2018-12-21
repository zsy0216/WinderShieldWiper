package zut.edu.cn.winder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rgLever;
    private RadioGroup rgDial;
    private RadioButton btnOff;
    private RadioButton btnInt;
    private RadioButton btnLow;
    private RadioButton btnHigh;
    private RadioButton btnOne;
    private RadioButton btnTwo;
    private RadioButton btnThree;
    private TextView tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        rgLever = findViewById(R.id.rg_lever);
        rgDial = findViewById(R.id.rg_dial);
        btnOff = findViewById(R.id.btn_off);
        btnInt = findViewById(R.id.btn_int);
        btnLow = findViewById(R.id.btn_low);
        btnHigh = findViewById(R.id.btn_high);
        btnOne = findViewById(R.id.btn_one);
        btnTwo = findViewById(R.id.btn_two);
        btnThree = findViewById(R.id.btn_three);
        tvInfo = findViewById(R.id.tv_info);
        /*
        * 设置按钮默认选中
        * */
        rgLever.check(btnOff.getId());
        rgDial.check(btnOne.getId());

        rgLever.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                /**
                 * 当控制杆处于关时，雨刷不摆动；
                 **/
                if(checkedId == btnOff.getId()) {
                    tvInfo.setText("雨刷：每分钟0次");
                    rgDial.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedId) {
                            if(checkedId == btnOne.getId())
                                tvInfo.setText("雨刷：每分钟0次");
                            else if(checkedId == btnTwo.getId())
                                tvInfo.setText("雨刷：每分钟0次");
                            else if(checkedId == btnThree.getId())
                                tvInfo.setText("雨刷：每分钟0次");
                        }
                    });
                }
                /*
                 * 当控制杆处于低速时，雨刷每分钟摆30次；
                 * */
                else if(checkedId == btnLow.getId()) {
                    tvInfo.setText("雨刷：每分钟30次");
                    rgDial.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedId) {
                            if(checkedId == btnOne.getId())
                                tvInfo.setText("雨刷：每分钟30次");
                            else if(checkedId == btnTwo.getId())
                                tvInfo.setText("雨刷：每分钟30次");
                            else if(checkedId == btnThree.getId())
                                tvInfo.setText("雨刷：每分钟30次");
                        }
                    });
                }

                /*
                 * 当控制杆处于高速时，雨刷每分钟摆60次；
                 * */
                else if(checkedId == btnHigh.getId()){
                    tvInfo.setText("雨刷：每分钟60次");
                    rgDial.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedId) {
                            if(checkedId == btnOne.getId())
                                tvInfo.setText("雨刷：每分钟60次");
                            else if(checkedId == btnTwo.getId())
                                tvInfo.setText("雨刷：每分钟60次");
                            else if(checkedId == btnThree.getId())
                                tvInfo.setText("雨刷：每分钟60次");
                        }
                    });
                }

                /*
                 *当控制杆处于间歇时，刻度盘
                 *    在1挡，雨刷每分钟摆4次；
                 *    在2挡，雨刷每分钟摆6次；
                 *    在3挡，雨刷每分钟摆12次；
                 * */
                if(checkedId == btnInt.getId()){
                    if(rgDial.getCheckedRadioButtonId()==R.id.btn_one){
                        tvInfo.setText("雨刷：每分钟4次");
                    }
                    else if(rgDial.getCheckedRadioButtonId()==R.id.btn_two){
                        tvInfo.setText("雨刷：每分钟6次");
                    }
                    else if(rgDial.getCheckedRadioButtonId()==R.id.btn_three){
                        tvInfo.setText("雨刷：每分钟12次");
                    }
                    rgDial.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedId) {
                            if(checkedId == btnOne.getId())
                                tvInfo.setText("雨刷：每分钟4次");
                            else if(checkedId == btnTwo.getId())
                                tvInfo.setText("雨刷：每分钟6次");
                            else if(checkedId == btnThree.getId())
                                tvInfo.setText("雨刷：每分钟12次");
                        }
                    });
                }
            }
        });
    }
}
