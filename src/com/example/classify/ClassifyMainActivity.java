package com.example.classify;

import java.util.ArrayList;
import java.util.List;

import com.example.main.R;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.TextView;

public class ClassifyMainActivity extends FragmentActivity {
	  private List<Fragment> mFragmentList = new ArrayList<Fragment>();  
	    private FragmentAdapter mFragmentAdapter;  
	      
	    private ViewPager mPageVp;  
	    /** 
	     * Tab显示内容TextView 
	     */  
	    private TextView mGround, mAttention, mKFriend;  
	    /** 
	     * Tab的那个引导线 
	     */  
	    private ImageView mTabLineIv;  
	    /** 
	     * Fragment 
	     */  
	    private GroundFragment GFragment;  
	    private AttentionFragment AFragment;  
	    private KFriendFragment KFFragment;  
	    /** 
	     * ViewPager的当前选中页 
	     */  
	    private int currentIndex;  
	    /** 
	     * 屏幕的宽度 
	     */  
	    private int screenWidth;  
	  
	    @Override  
	    protected void onCreate(Bundle savedInstanceState) {  
	        super.onCreate(savedInstanceState);  
	        setContentView(R.layout.cla_main_top);
	        initView();
	        innitEvent();
	    }

		private void innitEvent() {
			// TODO Auto-generated method stub
			
		}

		private void initView() {
			// TODO Auto-generated method stub
			mGround=(TextView) findViewById(R.id.id_ground);
			mAttention=(TextView) findViewById(R.id.id_attention);
			mKFriend=(TextView) findViewById(R.id.id_kfriend);
			
			mTabLineIv = (ImageView) this.findViewById(R.id.id_tab_line);
			mPageVp = (ViewPager) this.findViewById(R.id.id_page_vp);




			
		}
}
