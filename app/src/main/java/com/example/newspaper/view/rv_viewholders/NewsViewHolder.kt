package com.example.newspaper.view.rv_viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.newspaper.data.entity.Article
import com.example.newspaper.databinding.NewsItemBinding
import com.squareup.picasso.Picasso

class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    private val newsItemBinding = NewsItemBinding.bind(itemView)
    //Привязываем view из layout к переменным
    private val title = newsItemBinding.title
    private val source = newsItemBinding.source
    private val time =  newsItemBinding.time
    private val picture =  newsItemBinding.picture

    //В этом методе кладем данные из Article в наши view
    fun bind(article: Article) {
        //Устанавливаем заголовок
        title.text = article.title
        //Устанавливаем постер
        //Указываем контейнер, в которм будет "жить" наша картинка

        Picasso.get()
            .load(article.urlToImage)
//            .centerCrop()
            .into(picture)

//        Glide.with(itemView)
//            //Загружаем сам ресурс
//            .load(article.urlToImage)
//            //Центруем изображение
//            .centerCrop()
//            //Указываем ImageView, куда будем загружать изображение
//            .into(picture)
        //Устанавливаем описание
        source.text = article.source.name
        time.text = article.publishedAt

    }
}
