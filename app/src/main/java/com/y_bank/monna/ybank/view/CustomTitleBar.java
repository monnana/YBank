package com.y_bank.monna.ybank.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.y_bank.monna.ybank.R;

/**
 * 自定义标题栏
 * @author 廖梦青
 * @version 10/2/2019
 */

public class CustomTitleBar extends RelativeLayout {

    private ImageView ivHead;  //头像
    private ImageView ivScanf; //图标 扫一扫
    private ImageView ivBack;  //返回图标
    private TextView tvTitle;  //标题 Y-Bank
    private TextView tvScanf;  //文字 扫一扫
    private TextView ttScanf;  //标题 扫一扫

    /**
     * 构造函数
     *
     * @param context
     * @param attrs
     */
    public CustomTitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    /**
     * 初始化视图，获取控件
     *
     * @param context
     * @param attributeSet
     */
    private void initView(final Context context, AttributeSet attributeSet) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_titlebar, this);
        ivHead = (ImageView) inflate.findViewById(R.id.iv_head);
        tvTitle = (TextView) inflate.findViewById(R.id.tv_title);
        ivScanf = (ImageView) inflate.findViewById(R.id.iv_scanf);
        tvScanf = (TextView) inflate.findViewById(R.id.tv_scanf);
        ivBack = (ImageView) inflate.findViewById(R.id.iv_back);
        ttScanf = (TextView) inflate.findViewById(R.id.tt_scanf);
        init(context, attributeSet);
    }

    /**
     * 初始化资源文件
     *
     * @param context
     * @param attributeSet
     */
    public void init(Context context, AttributeSet attributeSet) {
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.CustomTitleBar);//获取类型资源
        String title = typedArray.getString(R.styleable.CustomTitleBar_title);//设置标题 Y-Bank类型
        String scanf = typedArray.getString(R.styleable.CustomTitleBar_scan); //设置文字 扫一扫类型
        String tscanf = typedArray.getString(R.styleable.CustomTitleBar_scan); //设置标题 扫一扫类型
        int headIcon = typedArray.getResourceId(R.styleable.CustomTitleBar_head_icon, R.drawable.headpor);//设置头像图片
        int scanfIcon = typedArray.getResourceId(R.styleable.CustomTitleBar_scanf_icon, R.drawable.homebt_flicking_normal);//设置扫一扫图片
        int backIcon = typedArray.getResourceId(R.styleable.CustomTitleBar_back_icon, R.drawable.returnarrow_normal);//设置返回图标

        //标题栏类型,默认为10
        int titleBarType = typedArray.getInt(R.styleable.CustomTitleBar_titlebar_type, 10);

        //赋值进去我们的标题栏
        tvTitle.setText(title);
        tvScanf.setText(scanf);
        ttScanf.setText(tscanf);
        ivHead.setImageResource(headIcon);
        ivScanf.setImageResource(scanfIcon);
        ivBack.setImageResource(backIcon);

        switch (titleBarType) {
            //仅显示Y-Bank
            case 9:
                tvTitle.setVisibility(View.VISIBLE);  //显示标题
                ivHead.setVisibility(View.GONE);      //隐藏头像
                ivScanf.setVisibility(View.GONE);     //隐藏扫一扫图标
                tvScanf.setVisibility(View.GONE);     //隐藏扫一扫文字
                ttScanf.setVisibility(View.GONE);     //隐藏扫一扫标题
                ivBack.setVisibility(View.GONE);      //隐藏返回按钮
                break;
            //显示首页标题栏
            case 10:
                tvTitle.setVisibility(View.VISIBLE);  //显示标题
                ivHead.setVisibility(View.VISIBLE);   //显示头像
                ivScanf.setVisibility(View.VISIBLE);  //显示扫一扫图标
                tvScanf.setVisibility(View.VISIBLE);  //显示扫一扫文字
                ttScanf.setVisibility(View.GONE);     //隐藏扫一扫标题
                ivBack.setVisibility(View.GONE);      //隐藏返回按钮
                break;
            //显示标题栏和返回按钮
            case 11:
                tvTitle.setVisibility(View.VISIBLE);  //显示标题
                ivBack.setVisibility(View.VISIBLE);   //显示返回按钮
                ivScanf.setVisibility(View.GONE);     //隐藏扫一扫图标
                tvScanf.setVisibility(View.GONE);     //隐藏扫一扫文字
                ttScanf.setVisibility(View.GONE);     //隐藏扫一扫标题
                ivHead.setVisibility(View.GONE);      //隐藏头像
                break;
            //显示扫一扫标题栏
            case 12:
                ttScanf.setVisibility(View.VISIBLE);//显示标题 扫一扫
                ivBack.setVisibility(View.VISIBLE);//显示返回按钮
                ivScanf.setVisibility(View.GONE);  //显示扫一扫图标
                tvScanf.setVisibility(View.GONE);  //显示扫一扫文字
                ivHead.setVisibility(View.GONE);   //隐藏头像
                tvTitle.setVisibility(View.GONE);  //隐藏标题 Y-Bank
                break;
        }

    }

    //返回键点击事件
    public void setBackIconOnClickListener(OnClickListener l) {

    }
}
