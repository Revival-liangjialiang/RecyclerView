package cn.edu.zafu.recyclerviewdemo;

import java.util.List;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import cn.edu.zafu.recyclerviewdemo.RecyclerAdapter.ItemViewHolder;

public class RecyclerAdapter extends RecyclerView.Adapter<ItemViewHolder> {
	private List<Item> items;

	// 点击监听事件
	interface OnRecyclerViewItemClickListener {
		void onClick(View view, int position);
	};

	private OnRecyclerViewItemClickListener listener;

	// 将数据赋值给成员变量
	public RecyclerAdapter(List<Item> items) {
		this.items = items;
	}

	// 设置监听器
	public void setListener(OnRecyclerViewItemClickListener listener) {
		this.listener = listener;
	}

	// 获得数据大小
	@Override
	public int getItemCount() {
		return items.size();
	}

	@Override
	public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
		// 将布局进行绑定
		View view = LayoutInflater.from(viewGroup.getContext()).inflate(
				R.layout.item, viewGroup, false);
		return new ItemViewHolder(view);
	}

	// 绑定数据
	@Override
	public void onBindViewHolder(final ItemViewHolder viewHolder,
			final int position) {
		Item item = items.get(position);
		viewHolder.img.setImageResource(item.getImg());
		viewHolder.title.setText(item.getTitle());
		viewHolder.description.setText(item.getDescription());
		viewHolder.time.setText(item.getTime());

		viewHolder.itemView.setOnClickListener(new OnClickListener() {
			// 如果监听器非空，则回调
			@Override
			public void onClick(View v) {
				if (listener != null) {
					listener.onClick(viewHolder.itemView, position);
				}

			}
		});
	}

	// 用于缓存提高效率
	public final static class ItemViewHolder extends RecyclerView.ViewHolder {
		// 每一项的四个控件
		ImageView img;
		TextView title;
		TextView description;
		TextView time;

		public ItemViewHolder(View itemView) {
			super(itemView);
			img = (ImageView) itemView.findViewById(R.id.img);
			title = (TextView) itemView.findViewById(R.id.title);
			description = (TextView) itemView.findViewById(R.id.description);
			time = (TextView) itemView.findViewById(R.id.time);
		}
	}
}
