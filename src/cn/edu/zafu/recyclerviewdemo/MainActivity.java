package cn.edu.zafu.recyclerviewdemo;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import cn.edu.zafu.recyclerviewdemo.RecyclerAdapter.OnRecyclerViewItemClickListener;

public class MainActivity extends Activity {
	private RecyclerView recyclerView;
	private ArrayList<Item> items = new ArrayList<Item>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initDatas();
		initViews();
	}
	private void initDatas() {
		Item item = new Item();
		item.setImg(R.drawable.icon);
		item.setTitle("微信支付1");
		item.setDescription("微信支付凭证");
		item.setTime("晚上20:35");
		items.add(item);

		item = new Item();
		item.setImg(R.drawable.icon);
		item.setTitle("微信支付2");
		item.setDescription("微信支付凭证");
		item.setTime("晚上20:35");
		items.add(item);

		item = new Item();
		item.setImg(R.drawable.icon);
		item.setTitle("微信支付3");
		item.setDescription("微信支付凭证");
		item.setTime("晚上20:35");
		items.add(item);

		item = new Item();
		item.setImg(R.drawable.icon);
		item.setTitle("微信支付4");
		item.setDescription("微信支付凭证");
		item.setTime("晚上20:35");
		items.add(item);

		item = new Item();
		item.setImg(R.drawable.icon);
		item.setTitle("微信支付5");
		item.setDescription("微信支付凭证");
		item.setTime("晚上20:35");
		items.add(item);

		item = new Item();
		item.setImg(R.drawable.icon);
		item.setTitle("微信支付6");
		item.setDescription("微信支付凭证");
		item.setTime("晚上20:35");
		items.add(item);

		item = new Item();
		item.setImg(R.drawable.icon);
		item.setTitle("微信支付7");
		item.setDescription("微信支付凭证");
		item.setTime("晚上20:35");
		items.add(item);
		
		
		item = new Item();
		item.setImg(R.drawable.icon);
		item.setTitle("微信支付8");
		item.setDescription("微信支付凭证");
		item.setTime("晚上20:35");
		items.add(item);
		
		item = new Item();
		item.setImg(R.drawable.icon);
		item.setTitle("微信支付9");
		item.setDescription("微信支付凭证");
		item.setTime("晚上20:35");
		items.add(item);
	}
	private void initViews() {
		//加载RecyclerView控件
		recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
		//新建适配器
		RecyclerAdapter adapter = new RecyclerAdapter(items);
		//设置监听器
		adapter.setListener(new OnRecyclerViewItemClickListener() {
			
			@Override
			public void onClick(View view, int position) {
				Toast.makeText(getApplicationContext(),position+"", Toast.LENGTH_LONG).show();
			}
		});
		//设置适配器
		recyclerView.setAdapter(adapter);
		//设置默认动画
		recyclerView.setItemAnimator(new DefaultItemAnimator());
		//设置布局管理器;      VERTICAL:垂直
		recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
		//设置每一项的装饰，这里加入分割线；ItemDecoration：项装饰。
		recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
			//Paint：绘图
			Paint paint = new Paint();
			@Override
			public void onDraw(Canvas c, RecyclerView parent,
					RecyclerView.State state) {
				super.onDraw(c, parent, state);
			}
			//Canvas：帆布；RecyclerView：回收期；State：状态；onDrawOver：画上。
			@Override
			public void onDrawOver(Canvas c, RecyclerView parent,
					RecyclerView.State state) {
				super.onDrawOver(c, parent, state);
				paint.setColor(Color.BLUE);
				for (int i = 0, size = parent.getChildCount(); i < size; i++) {
					View child = parent.getChildAt(i);
					c.drawLine(child.getLeft(), child.getBottom(),child.getRight(), child.getBottom(), paint);
				}
			}

		});
		//可以提高效率
		recyclerView.setHasFixedSize(true);
	}
	
}
