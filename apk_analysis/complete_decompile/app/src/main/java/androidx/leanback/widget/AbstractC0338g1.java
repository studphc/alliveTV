package androidx.leanback.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.widget.ItemAlignmentFacet;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.leanback.widget.g1 */
/* loaded from: classes.dex */
public abstract class AbstractC0338g1 {

    /* renamed from: a */
    public static final Rect f6299a = new Rect();

    /* renamed from: a */
    public static int m1499a(View view, ItemAlignmentFacet.ItemAlignmentDef itemAlignmentDef, int i) {
        View view2;
        int i2;
        int height;
        int width;
        int width2;
        int width3;
        C0377q0 c0377q0 = (C0377q0) view.getLayoutParams();
        int i3 = itemAlignmentDef.f5862a;
        if (i3 == 0 || (view2 = view.findViewById(i3)) == null) {
            view2 = view;
        }
        int i4 = itemAlignmentDef.f5864c;
        Rect rect = f6299a;
        if (i == 0) {
            if (view.getLayoutDirection() == 1) {
                if (view2 == view) {
                    c0377q0.getClass();
                    width2 = (view2.getWidth() - c0377q0.f6398e) - c0377q0.f6400g;
                } else {
                    width2 = view2.getWidth();
                }
                int i5 = width2 - i4;
                if (itemAlignmentDef.f5866e) {
                    float f = itemAlignmentDef.f5865d;
                    if (f == RecyclerView.f7068F0) {
                        i5 -= view2.getPaddingRight();
                    } else if (f == 100.0f) {
                        i5 += view2.getPaddingLeft();
                    }
                }
                if (itemAlignmentDef.f5865d != -1.0f) {
                    if (view2 == view) {
                        c0377q0.getClass();
                        width3 = (view2.getWidth() - c0377q0.f6398e) - c0377q0.f6400g;
                    } else {
                        width3 = view2.getWidth();
                    }
                    i5 -= (int) ((width3 * itemAlignmentDef.f5865d) / 100.0f);
                }
                if (view != view2) {
                    rect.right = i5;
                    ((ViewGroup) view).offsetDescendantRectToMyCoords(view2, rect);
                    return rect.right + c0377q0.f6400g;
                }
                return i5;
            }
            if (itemAlignmentDef.f5866e) {
                float f2 = itemAlignmentDef.f5865d;
                if (f2 == RecyclerView.f7068F0) {
                    i4 += view2.getPaddingLeft();
                } else if (f2 == 100.0f) {
                    i4 -= view2.getPaddingRight();
                }
            }
            if (itemAlignmentDef.f5865d != -1.0f) {
                if (view2 == view) {
                    c0377q0.getClass();
                    width = (view2.getWidth() - c0377q0.f6398e) - c0377q0.f6400g;
                } else {
                    width = view2.getWidth();
                }
                i4 += (int) ((width * itemAlignmentDef.f5865d) / 100.0f);
            }
            int i6 = i4;
            if (view != view2) {
                rect.left = i6;
                ((ViewGroup) view).offsetDescendantRectToMyCoords(view2, rect);
                return rect.left - c0377q0.f6398e;
            }
            return i6;
        }
        if (itemAlignmentDef.f5866e) {
            float f3 = itemAlignmentDef.f5865d;
            if (f3 == RecyclerView.f7068F0) {
                i4 += view2.getPaddingTop();
            } else if (f3 == 100.0f) {
                i4 -= view2.getPaddingBottom();
            }
        }
        if (itemAlignmentDef.f5865d != -1.0f) {
            if (view2 == view) {
                c0377q0.getClass();
                height = (view2.getHeight() - c0377q0.f6399f) - c0377q0.f6401h;
            } else {
                height = view2.getHeight();
            }
            i4 += (int) ((height * itemAlignmentDef.f5865d) / 100.0f);
        }
        if (view != view2) {
            rect.top = i4;
            ((ViewGroup) view).offsetDescendantRectToMyCoords(view2, rect);
            i2 = rect.top - c0377q0.f6399f;
        } else {
            i2 = i4;
        }
        if (itemAlignmentDef.isAlignedToTextViewBaseLine()) {
            return i2 + view2.getBaseline();
        }
        return i2;
    }
}
