package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.motion.widget.KeyAttributes;
import androidx.constraintlayout.motion.widget.KeyPosition;
import androidx.constraintlayout.motion.widget.MotionController;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;

/* loaded from: classes.dex */
public class MotionEffect extends MotionHelper {
    public static final int AUTO = -1;
    public static final int EAST = 2;
    public static final int NORTH = 0;
    public static final int SOUTH = 1;
    public static final String TAG = "FadeMove";
    public static final int WEST = 3;

    /* renamed from: e */
    public float f2675e;

    /* renamed from: f */
    public int f2676f;

    /* renamed from: g */
    public int f2677g;

    /* renamed from: h */
    public int f2678h;

    /* renamed from: i */
    public int f2679i;

    /* renamed from: j */
    public boolean f2680j;

    /* renamed from: k */
    public int f2681k;

    /* renamed from: l */
    public int f2682l;

    public MotionEffect(Context context) {
        super(context);
        this.f2675e = 0.1f;
        this.f2676f = 49;
        this.f2677g = 50;
        this.f2678h = 0;
        this.f2679i = 0;
        this.f2680j = true;
        this.f2681k = -1;
        this.f2682l = -1;
    }

    /* renamed from: f */
    public final void m552f(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MotionEffect);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.MotionEffect_motionEffect_start) {
                    int i2 = obtainStyledAttributes.getInt(index, this.f2676f);
                    this.f2676f = i2;
                    this.f2676f = Math.max(Math.min(i2, 99), 0);
                } else if (index == R.styleable.MotionEffect_motionEffect_end) {
                    int i3 = obtainStyledAttributes.getInt(index, this.f2677g);
                    this.f2677g = i3;
                    this.f2677g = Math.max(Math.min(i3, 99), 0);
                } else if (index == R.styleable.MotionEffect_motionEffect_translationX) {
                    this.f2678h = obtainStyledAttributes.getDimensionPixelOffset(index, this.f2678h);
                } else if (index == R.styleable.MotionEffect_motionEffect_translationY) {
                    this.f2679i = obtainStyledAttributes.getDimensionPixelOffset(index, this.f2679i);
                } else if (index == R.styleable.MotionEffect_motionEffect_alpha) {
                    this.f2675e = obtainStyledAttributes.getFloat(index, this.f2675e);
                } else if (index == R.styleable.MotionEffect_motionEffect_move) {
                    this.f2682l = obtainStyledAttributes.getInt(index, this.f2682l);
                } else if (index == R.styleable.MotionEffect_motionEffect_strict) {
                    this.f2680j = obtainStyledAttributes.getBoolean(index, this.f2680j);
                } else if (index == R.styleable.MotionEffect_motionEffect_viewTransition) {
                    this.f2681k = obtainStyledAttributes.getResourceId(index, this.f2681k);
                }
            }
            int i4 = this.f2676f;
            int i5 = this.f2677g;
            if (i4 == i5) {
                if (i4 > 0) {
                    this.f2676f = i4 - 1;
                } else {
                    this.f2677g = i5 + 1;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionHelperInterface
    public boolean isDecorator() {
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x0185, code lost:
    
        if (r14 == androidx.recyclerview.widget.RecyclerView.f7068F0) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0199, code lost:
    
        if (r14 == androidx.recyclerview.widget.RecyclerView.f7068F0) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01a9, code lost:
    
        if (r15 == androidx.recyclerview.widget.RecyclerView.f7068F0) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01b9, code lost:
    
        if (r15 == androidx.recyclerview.widget.RecyclerView.f7068F0) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01e4  */
    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionHelperInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onPreSetup(MotionLayout motionLayout, HashMap<View, MotionController> hashMap) {
        Key key;
        Key key2;
        Key key3;
        int i;
        HashMap<View, MotionController> hashMap2 = hashMap;
        View[] views = getViews((ConstraintLayout) getParent());
        if (views == null) {
            Log.v(TAG, Debug.getLoc() + " views = null");
            return;
        }
        Key keyAttributes = new KeyAttributes();
        Key keyAttributes2 = new KeyAttributes();
        keyAttributes.setValue("alpha", Float.valueOf(this.f2675e));
        keyAttributes2.setValue("alpha", Float.valueOf(this.f2675e));
        keyAttributes.setFramePosition(this.f2676f);
        keyAttributes2.setFramePosition(this.f2677g);
        KeyPosition keyPosition = new KeyPosition();
        keyPosition.setFramePosition(this.f2676f);
        keyPosition.setType(0);
        keyPosition.setValue("percentX", 0);
        keyPosition.setValue("percentY", 0);
        KeyPosition keyPosition2 = new KeyPosition();
        keyPosition2.setFramePosition(this.f2677g);
        keyPosition2.setType(0);
        keyPosition2.setValue("percentX", 1);
        keyPosition2.setValue("percentY", 1);
        Key key4 = null;
        if (this.f2678h > 0) {
            key = new KeyAttributes();
            key2 = new KeyAttributes();
            key.setValue("translationX", Integer.valueOf(this.f2678h));
            key.setFramePosition(this.f2677g);
            key2.setValue("translationX", 0);
            key2.setFramePosition(this.f2677g - 1);
        } else {
            key = null;
            key2 = null;
        }
        if (this.f2679i > 0) {
            key4 = new KeyAttributes();
            key3 = new KeyAttributes();
            key4.setValue("translationY", Integer.valueOf(this.f2679i));
            key4.setFramePosition(this.f2677g);
            key3.setValue("translationY", 0);
            key3.setFramePosition(this.f2677g - 1);
        } else {
            key3 = null;
        }
        int i2 = this.f2682l;
        if (i2 == -1) {
            int[] iArr = new int[4];
            for (View view : views) {
                MotionController motionController = hashMap2.get(view);
                if (motionController != null) {
                    float finalX = motionController.getFinalX() - motionController.getStartX();
                    float finalY = motionController.getFinalY() - motionController.getStartY();
                    if (finalY < RecyclerView.f7068F0) {
                        iArr[1] = iArr[1] + 1;
                    }
                    if (finalY > RecyclerView.f7068F0) {
                        iArr[0] = iArr[0] + 1;
                    }
                    if (finalX > RecyclerView.f7068F0) {
                        iArr[3] = iArr[3] + 1;
                    }
                    if (finalX < RecyclerView.f7068F0) {
                        iArr[2] = iArr[2] + 1;
                    }
                }
            }
            int i3 = iArr[0];
            i2 = 0;
            for (int i4 = 1; i4 < 4; i4++) {
                int i5 = iArr[i4];
                if (i3 < i5) {
                    i3 = i5;
                    i2 = i4;
                }
            }
        }
        int i6 = 0;
        while (i6 < views.length) {
            MotionController motionController2 = hashMap2.get(views[i6]);
            if (motionController2 != null) {
                float finalX2 = motionController2.getFinalX() - motionController2.getStartX();
                float finalY2 = motionController2.getFinalY() - motionController2.getStartY();
                if (i2 == 0) {
                    if (finalY2 > RecyclerView.f7068F0) {
                        if (this.f2680j) {
                        }
                    }
                    i = this.f2681k;
                    if (i != -1) {
                        motionController2.addKey(keyAttributes);
                        motionController2.addKey(keyAttributes2);
                        motionController2.addKey(keyPosition);
                        motionController2.addKey(keyPosition2);
                        if (this.f2678h > 0) {
                            motionController2.addKey(key);
                            motionController2.addKey(key2);
                        }
                        if (this.f2679i > 0) {
                            motionController2.addKey(key4);
                            motionController2.addKey(key3);
                        }
                    } else {
                        motionLayout.applyViewTransition(i, motionController2);
                    }
                } else if (i2 == 1) {
                    if (finalY2 < RecyclerView.f7068F0) {
                        if (this.f2680j) {
                        }
                    }
                    i = this.f2681k;
                    if (i != -1) {
                    }
                } else if (i2 == 2) {
                    if (finalX2 < RecyclerView.f7068F0) {
                        if (this.f2680j) {
                        }
                    }
                    i = this.f2681k;
                    if (i != -1) {
                    }
                } else {
                    if (i2 == 3) {
                        if (finalX2 > RecyclerView.f7068F0) {
                            if (this.f2680j) {
                            }
                        }
                    }
                    i = this.f2681k;
                    if (i != -1) {
                    }
                }
                i6++;
                hashMap2 = hashMap;
            }
            i6++;
            hashMap2 = hashMap;
        }
    }

    public MotionEffect(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2675e = 0.1f;
        this.f2676f = 49;
        this.f2677g = 50;
        this.f2678h = 0;
        this.f2679i = 0;
        this.f2680j = true;
        this.f2681k = -1;
        this.f2682l = -1;
        m552f(context, attributeSet);
    }

    public MotionEffect(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2675e = 0.1f;
        this.f2676f = 49;
        this.f2677g = 50;
        this.f2678h = 0;
        this.f2679i = 0;
        this.f2680j = true;
        this.f2681k = -1;
        this.f2682l = -1;
        m552f(context, attributeSet);
    }
}
