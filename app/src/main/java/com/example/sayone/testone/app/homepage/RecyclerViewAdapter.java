package com.example.sayone.testone.app.homepage;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sayone.testone.R;
import com.example.sayone.testone.model.ImageListModel;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ImageViewHolder>{

    private List<ImageListModel> mImageListModel;
    RecyclerViewAdapter recyclerViewAdapter=this;
    private Context mcontext;
    public RecyclerViewAdapter(List<ImageListModel> imageListModel, Context context){
        mImageListModel=imageListModel;
        mcontext=context;
    }
    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.img_list_views,viewGroup,false);
        ImageViewHolder imghold=new ImageViewHolder(view);
        return imghold;
    }


    @Override
    public int getItemCount() {
        return mImageListModel.size();
    }

    @Override
    public void onBindViewHolder(@NonNull final ImageViewHolder holder, final int position) {
        holder.mMyimages.setImageDrawable(mImageListModel.get(position).getImg_drawable());
        holder.mTitle.setText(mImageListModel.get(position).getTxt());
       holder.mCv.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(mcontext, WebActivity.class);
               mcontext.startActivity(intent);
           }
       });

       holder.mCard_menue.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               PopupMenu menu = new PopupMenu(mcontext,v);
               menu.getMenuInflater().inflate(R.menu.menu,menu.getMenu());
               menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                   @Override
                   public boolean onMenuItemClick(MenuItem item) {



                       removeData(position);
                       recyclerViewAdapter.notifyDataSetChanged();
                       Toast.makeText(holder.mCv.getContext(), "deleted", Toast.LENGTH_SHORT).show();
                      // Toast.makeText(mContext, "deleted position : "+position, Toast.LENGTH_SHORT).show();
                       return false;
                   }
               });
               menu.show();

           }
       });
    }

    private void removeData(int pos){
        mImageListModel.remove(pos);
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        CardView mCv;
        TextView mTitle;
        ImageView mMyimages,mCard_menue;
        public ImageViewHolder(View itemView) {
            super(itemView);

            mCv = itemView.findViewById(R.id.imageListCard);
            mMyimages=itemView.findViewById(R.id.imgframe);
            mTitle=itemView.findViewById(R.id.imgtitle);
            mCard_menue=itemView.findViewById(R.id.card_menue_button);

        }
    }
}
