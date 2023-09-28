package com.example.projeklinierlayoutjava;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder> {
        private ArrayList<Mahasiswa> datalList;

        public MahasiswaAdapter(ArrayList<Mahasiswa> datalList){
            this.datalList = datalList;
        }

        @Override
        public MahasiswaAdapter.MahasiswaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.recycleview,parent, false);
            return new MahasiswaViewHolder(view);
        }

        @Override
        public void onBindViewHolder( MahasiswaAdapter.MahasiswaViewHolder holder, int position) {
        holder.txtNama.setText(datalList.get(position).getNama());
        holder.txtNpm.setText(datalList.get(position).getNpm());
        holder.txtNoHp.setText(datalList.get(position).getNohp());
        }

        @Override
        public int getItemCount() {
            return (datalList != null) ? datalList.size() : 0;
        }

    public class MahasiswaViewHolder extends RecyclerView.ViewHolder {
        private TextView txtNama, txtNpm, txtNoHp;
        public MahasiswaViewHolder(View itemView) {
            super(itemView);
            txtNama =(TextView) itemView.findViewById(R.id.txt_nama_mahasiswa);
            txtNpm =(TextView) itemView.findViewById(R.id.txt_npm_mahasiswa);
            txtNoHp =(TextView) itemView.findViewById(R.id.txt_nohp_mahasiswa);
        }
    }
}
