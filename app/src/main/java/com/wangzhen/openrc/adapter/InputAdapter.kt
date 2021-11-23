package com.wangzhen.openrc.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.ToggleButton
import androidx.recyclerview.widget.RecyclerView
import com.wangzhen.openrc.R
import com.wangzhen.openrc.data.Data
import com.wangzhen.openrc.model.Input
import com.wangzhen.openrc.view.UiRes

class InputAdapter : RecyclerView.Adapter<PinMapAdapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PinMapAdapterViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.input_item, parent, false)

        return PinMapAdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: PinMapAdapterViewHolder, position: Int) {
        val input: Input = Data.inputList[position]
        holder.name.text = input.name
        holder.name.setBackgroundColor(UiRes.listUiColor[position])
        holder.toggleButton.isChecked = Data.autoResetList[position] == 1
        holder.toggleButton.setOnCheckedChangeListener { _, isChecked ->
            Data.autoResetList[position] = if (isChecked) {
                1
            } else {
                0
            }
        }
    }

    override fun getItemCount(): Int {
        return Data.inputList.size - 1
    }

}

class PinMapAdapterViewHolder(vew: View) : RecyclerView.ViewHolder(vew) {
    var name: TextView = vew.findViewById(R.id.tv_name)
    var toggleButton: ToggleButton = vew.findViewById(R.id.toggleButton)
}
