package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class Constraints extends ViewGroup {
    public static final String TAG = "Constraints";

    /* renamed from: a */
    public ConstraintSet f3197a;

    public Constraints(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public ConstraintSet getConstraintSet() {
        if (this.f3197a == null) {
            this.f3197a = new ConstraintSet();
        }
        this.f3197a.clone(this);
        return this.f3197a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public Constraints(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Log.v(TAG, " ################# init");
        super.setVisibility(8);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ConstraintLayout.LayoutParams(layoutParams);
    }

    public Constraints(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Log.v(TAG, " ################# init");
        super.setVisibility(8);
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ConstraintLayout.LayoutParams {
        public float alpha;
        public boolean applyElevation;
        public float elevation;
        public float rotation;
        public float rotationX;
        public float rotationY;
        public float scaleX;
        public float scaleY;
        public float transformPivotX;
        public float transformPivotY;
        public float translationX;
        public float translationY;
        public float translationZ;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.alpha = 1.0f;
            this.applyElevation = false;
            this.elevation = RecyclerView.f7068F0;
            this.rotation = RecyclerView.f7068F0;
            this.rotationX = RecyclerView.f7068F0;
            this.rotationY = RecyclerView.f7068F0;
            this.scaleX = 1.0f;
            this.scaleY = 1.0f;
            this.transformPivotX = RecyclerView.f7068F0;
            this.transformPivotY = RecyclerView.f7068F0;
            this.translationX = RecyclerView.f7068F0;
            this.translationY = RecyclerView.f7068F0;
            this.translationZ = RecyclerView.f7068F0;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.alpha = 1.0f;
            this.applyElevation = false;
            this.elevation = RecyclerView.f7068F0;
            this.rotation = RecyclerView.f7068F0;
            this.rotationX = RecyclerView.f7068F0;
            this.rotationY = RecyclerView.f7068F0;
            this.scaleX = 1.0f;
            this.scaleY = 1.0f;
            this.transformPivotX = RecyclerView.f7068F0;
            this.transformPivotY = RecyclerView.f7068F0;
            this.translationX = RecyclerView.f7068F0;
            this.translationY = RecyclerView.f7068F0;
            this.translationZ = RecyclerView.f7068F0;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.alpha = 1.0f;
            this.applyElevation = false;
            this.elevation = RecyclerView.f7068F0;
            this.rotation = RecyclerView.f7068F0;
            this.rotationX = RecyclerView.f7068F0;
            this.rotationY = RecyclerView.f7068F0;
            this.scaleX = 1.0f;
            this.scaleY = 1.0f;
            this.transformPivotX = RecyclerView.f7068F0;
            this.transformPivotY = RecyclerView.f7068F0;
            this.translationX = RecyclerView.f7068F0;
            this.translationY = RecyclerView.f7068F0;
            this.translationZ = RecyclerView.f7068F0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ConstraintSet);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.ConstraintSet_android_alpha) {
                    this.alpha = obtainStyledAttributes.getFloat(index, this.alpha);
                } else if (index == R.styleable.ConstraintSet_android_elevation) {
                    this.elevation = obtainStyledAttributes.getFloat(index, this.elevation);
                    this.applyElevation = true;
                } else if (index == R.styleable.ConstraintSet_android_rotationX) {
                    this.rotationX = obtainStyledAttributes.getFloat(index, this.rotationX);
                } else if (index == R.styleable.ConstraintSet_android_rotationY) {
                    this.rotationY = obtainStyledAttributes.getFloat(index, this.rotationY);
                } else if (index == R.styleable.ConstraintSet_android_rotation) {
                    this.rotation = obtainStyledAttributes.getFloat(index, this.rotation);
                } else if (index == R.styleable.ConstraintSet_android_scaleX) {
                    this.scaleX = obtainStyledAttributes.getFloat(index, this.scaleX);
                } else if (index == R.styleable.ConstraintSet_android_scaleY) {
                    this.scaleY = obtainStyledAttributes.getFloat(index, this.scaleY);
                } else if (index == R.styleable.ConstraintSet_android_transformPivotX) {
                    this.transformPivotX = obtainStyledAttributes.getFloat(index, this.transformPivotX);
                } else if (index == R.styleable.ConstraintSet_android_transformPivotY) {
                    this.transformPivotY = obtainStyledAttributes.getFloat(index, this.transformPivotY);
                } else if (index == R.styleable.ConstraintSet_android_translationX) {
                    this.translationX = obtainStyledAttributes.getFloat(index, this.translationX);
                } else if (index == R.styleable.ConstraintSet_android_translationY) {
                    this.translationY = obtainStyledAttributes.getFloat(index, this.translationY);
                } else if (index == R.styleable.ConstraintSet_android_translationZ) {
                    this.translationZ = obtainStyledAttributes.getFloat(index, this.translationZ);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }
}
