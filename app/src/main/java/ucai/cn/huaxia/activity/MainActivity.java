package ucai.cn.huaxia.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import ucai.cn.huaxia.R;
import ucai.cn.huaxia.fragment.Bbar_BuyFragment;
import ucai.cn.huaxia.fragment.Bbar_MessageFragment;
import ucai.cn.huaxia.fragment.Bbar_favoriteFragment;
import ucai.cn.huaxia.fragment.ErrondFragment;
import ucai.cn.huaxia.fragment.PersonalFragment;

public class MainActivity extends BaseActivity{

    RadioButton[] Radiu;
    Fragment[] fragments;
    Bbar_BuyFragment buyFragment;
    Bbar_favoriteFragment favoriteFragment;
    Bbar_MessageFragment messageFragment;
    ErrondFragment errondFragment;
    PersonalFragment personalFragment;
    private int index;
    private int currentTabIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        buyFragment = new Bbar_BuyFragment();
        favoriteFragment = new Bbar_favoriteFragment();
        messageFragment = new Bbar_MessageFragment();
        errondFragment = new ErrondFragment();
        personalFragment = new PersonalFragment();
        fragments = new Fragment[]{buyFragment, favoriteFragment, messageFragment, errondFragment, personalFragment};
        getSupportFragmentManager().beginTransaction().add(R.id.fl,fragments[0])
                .add(R.id.fl,fragments[1]).hide(fragments[1])
                .add(R.id.fl,fragments[2]).hide(fragments[2])
                .add(R.id.fl,fragments[3]).hide(fragments[3])
                .add(R.id.fl,fragments[4]).hide(fragments[4])
                .show(fragments[0])
                .commit();
    }

    private void initView() {
        Radiu = new RadioButton[5];
        Radiu[0] = (RadioButton) findViewById(R.id.buy);
        Radiu[1] = (RadioButton) findViewById(R.id.favorite);
        Radiu[2] = (RadioButton) findViewById(R.id.message);
        Radiu[3] = (RadioButton) findViewById(R.id.Errands);
        Radiu[4] = (RadioButton) findViewById(R.id.me);
        Radiu[0].setSelected(true);
        registerForContextMenu(Radiu[1]);
    }

    public void onCheckedChange(View view) {
        switch (view.getId()) {
            case R.id.buy:
                index = 0;
                break;
            case R.id.favorite:
                index = 1;
                break;
            case R.id.message:
                index = 2;
                break;
            case R.id.Errands:
                    index = 3;
                break;
            case R.id.me:
                    index = 4;
                break;
        }
        if (currentTabIndex != index) {
            FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
            trx.hide(fragments[currentTabIndex]);
            if (!fragments[index].isAdded()) {
                trx.add(R.id.fl, fragments[index]);
            }
            trx.show(fragments[index]).commit();
            Radiu[currentTabIndex].setChecked(false);
            // 把当前tab设为选中状态
            Radiu[index].setChecked(true);
            currentTabIndex = index;
        }
    }
}
