package testscreen.test.com.testscreen;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.PopupWindow;

import testscreen.test.com.testscreen.R;

/**
 * @author:Victory
 * @time: 2018/4/27
 * @Email:949021037@qq.com
 * @QQ:949021037
 * @explain;
 */

public class PopScreen extends PopupWindow {
    private Context mContext;
    private View view;
    private GridView brand, price;
    private String[] brandList = {"华为", "小米", "三星", "OPPO", "苹果", "VIVO", "魅族"};
    private String[] priceList = {"0-1000", "1001-1499", "1500-1999", "2000-2999", "3000-3999", "4000-4999", "5000以上"};

    public PopScreen(Context context) {
        this.mContext = context;
        init();
    }

    private void init() {
        view = LayoutInflater.from(mContext).inflate(R.layout.pop_window, null);
        brand = view.findViewById(R.id.brand);
        price = view.findViewById(R.id.price);
        setmPopWindow();
        setData();
    }

    private void setData() {
        ArrayAdapter arrayAdapter = new ArrayAdapter(mContext, R.layout.item, R.id.text, brandList);
        brand.setAdapter(arrayAdapter);

        ArrayAdapter arrayAdapter3 = new ArrayAdapter(mContext, R.layout.item, R.id.text, priceList);
        price.setAdapter(arrayAdapter3);
    }

    public void setmPopWindow() {
        // 把View添加到PopWindow中
        this.setContentView(view);
        //设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(dp2px(300));
        //设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        //  设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(false);
        //   设置背景透明
        this.setBackgroundDrawable(new ColorDrawable(0x00000000));
    }

    public int dp2px( float dipValue) {
        final float scale = mContext.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }
}
