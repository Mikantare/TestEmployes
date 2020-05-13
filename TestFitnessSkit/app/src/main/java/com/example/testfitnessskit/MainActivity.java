package com.example.testfitnessskit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.testfitnessskit.API.ApiFactory;
import com.example.testfitnessskit.API.ApiServis;
import com.example.testfitnessskit.adapter.LessonAdapter;
import com.example.testfitnessskit.pojo.Lesson;
import com.example.testfitnessskit.pojo.LessonRespone;
import com.example.testfitnessskit.pojo.TeacherV2;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewLessons;
    private LessonAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewLessons = findViewById(R.id.recyclerViewLessons);
        adapter = new LessonAdapter();
        adapter.setLessons(new ArrayList<Lesson>());
        recyclerViewLessons.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewLessons.setAdapter(adapter);
        ApiFactory apiFactory = ApiFactory.getInstance();
        ApiServis apiServis = apiFactory.getApiServis();
        apiServis.getLessons()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LessonRespone>() {
                    @Override
                    public void accept(LessonRespone lessonRespone) throws Exception {
                    adapter.setLessons(lessonRespone.getResponse());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.i("throwable", throwable.getMessage());
                    }
                });


    }
}
