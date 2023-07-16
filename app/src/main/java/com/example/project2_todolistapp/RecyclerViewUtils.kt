package com.example.project2_todolistapp

import android.provider.ContactsContract.CommonDataKinds.Note
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.project2_todolistapp.databinding.TodoListItemBinding
import com.example.project2_todolistapp.db.Todo

class TodoListViewHolder(private val itemBinding: TodoListItemBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {
    fun bindData(todo: Todo) {
        itemBinding.cdItemTodo.isChecked = todo.isMarkedDone
        itemBinding.tvItemTodoTitle.text = todo.title
        itemBinding.tvItemTodoDesc.text = todo.desc
        itemBinding.tvItemTodoDate.text = todo.date.toString()
    }
}

class TodoListAdapter(
    private var listOfTodos: MutableList<Todo>
) : RecyclerView.Adapter<TodoListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListViewHolder {
        return TodoListViewHolder(
            TodoListItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = listOfTodos.size

    override fun onBindViewHolder(holder: TodoListViewHolder, position: Int) {
        holder.bindData(listOfTodos[position])
    }

    fun updateData(newList: MutableList<Todo>) {
        listOfTodos = newList
        notifyDataSetChanged()
    }

    fun addNewItem(todo: Todo) {
        listOfTodos.add(0, todo)
        notifyItemInserted(0)
    }
}

interface TodoStateChangedListener {
    fun onCheckStateChanged(position: Int)
}