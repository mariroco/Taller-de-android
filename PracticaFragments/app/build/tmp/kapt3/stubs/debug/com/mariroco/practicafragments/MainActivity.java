package com.mariroco.practicafragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0006\u0010\u001e\u001a\u00020\u001dJ\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u0006\u0010 \u001a\u00020\u001dJ\u0012\u0010!\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0014J\u000e\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\nJ\u0016\u0010&\u001a\u00020\u001d2\u0006\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020*J\u0014\u0010+\u001a\u00020\u001d2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lcom/mariroco/practicafragments/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "btnInfo", "Landroid/widget/Button;", "containerFrag", "Landroid/widget/FrameLayout;", "containerMain", "Landroidx/constraintlayout/widget/ConstraintLayout;", "counter", "", "getCounter", "()I", "setCounter", "(I)V", "imageList", "", "Lcom/mariroco/practicafragments/Image;", "getImageList", "()Ljava/util/List;", "setImageList", "(Ljava/util/List;)V", "imgvImage", "Landroid/widget/ImageView;", "imgvNext", "imgvPrevious", "mp", "Landroid/media/MediaPlayer;", "changeImage", "", "changeVisibility", "getSharedPref", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "playSound", "sound", "replaceFragment", "fragment", "Landroidx/fragment/app/Fragment;", "tag", "", "saveSharedPref", "images", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private android.widget.ImageView imgvImage;
    private android.widget.ImageView imgvPrevious;
    private android.widget.ImageView imgvNext;
    private android.widget.Button btnInfo;
    private androidx.constraintlayout.widget.ConstraintLayout containerMain;
    private android.widget.FrameLayout containerFrag;
    private android.media.MediaPlayer mp;
    public java.util.List<com.mariroco.practicafragments.Image> imageList;
    private int counter = 0;
    
    public MainActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.mariroco.practicafragments.Image> getImageList() {
        return null;
    }
    
    public final void setImageList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.mariroco.practicafragments.Image> p0) {
    }
    
    public final int getCounter() {
        return 0;
    }
    
    public final void setCounter(int p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void initView() {
    }
    
    public final void changeVisibility() {
    }
    
    private final void changeImage() {
    }
    
    public final void replaceFragment(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment fragment, @org.jetbrains.annotations.NotNull()
    java.lang.String tag) {
    }
    
    public final void saveSharedPref(@org.jetbrains.annotations.NotNull()
    java.util.List<com.mariroco.practicafragments.Image> images) {
    }
    
    public final void playSound(int sound) {
    }
    
    private final java.util.List<com.mariroco.practicafragments.Image> getSharedPref() {
        return null;
    }
}