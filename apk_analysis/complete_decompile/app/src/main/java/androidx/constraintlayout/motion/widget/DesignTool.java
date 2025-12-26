package androidx.constraintlayout.motion.widget;

import android.graphics.RectF;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import p000.j71;
import p000.lp1;

/* loaded from: classes.dex */
public class DesignTool {

    /* renamed from: f */
    public static final HashMap f2693f;

    /* renamed from: g */
    public static final HashMap f2694g;

    /* renamed from: a */
    public final MotionLayout f2695a;

    /* renamed from: b */
    public String f2696b = null;

    /* renamed from: c */
    public String f2697c = null;

    /* renamed from: d */
    public int f2698d = -1;

    /* renamed from: e */
    public int f2699e = -1;

    static {
        HashMap hashMap = new HashMap();
        f2693f = hashMap;
        HashMap hashMap2 = new HashMap();
        f2694g = hashMap2;
        hashMap.put(Pair.create(4, 4), "layout_constraintBottom_toBottomOf");
        hashMap.put(Pair.create(4, 3), "layout_constraintBottom_toTopOf");
        hashMap.put(Pair.create(3, 4), "layout_constraintTop_toBottomOf");
        hashMap.put(Pair.create(3, 3), "layout_constraintTop_toTopOf");
        hashMap.put(Pair.create(6, 6), "layout_constraintStart_toStartOf");
        hashMap.put(Pair.create(6, 7), "layout_constraintStart_toEndOf");
        hashMap.put(Pair.create(7, 6), "layout_constraintEnd_toStartOf");
        hashMap.put(Pair.create(7, 7), "layout_constraintEnd_toEndOf");
        hashMap.put(Pair.create(1, 1), "layout_constraintLeft_toLeftOf");
        hashMap.put(Pair.create(1, 2), "layout_constraintLeft_toRightOf");
        hashMap.put(Pair.create(2, 2), "layout_constraintRight_toRightOf");
        hashMap.put(Pair.create(2, 1), "layout_constraintRight_toLeftOf");
        hashMap.put(Pair.create(5, 5), "layout_constraintBaseline_toBaselineOf");
        hashMap2.put("layout_constraintBottom_toBottomOf", "layout_marginBottom");
        hashMap2.put("layout_constraintBottom_toTopOf", "layout_marginBottom");
        hashMap2.put("layout_constraintTop_toBottomOf", "layout_marginTop");
        hashMap2.put("layout_constraintTop_toTopOf", "layout_marginTop");
        hashMap2.put("layout_constraintStart_toStartOf", "layout_marginStart");
        hashMap2.put("layout_constraintStart_toEndOf", "layout_marginStart");
        hashMap2.put("layout_constraintEnd_toStartOf", "layout_marginEnd");
        hashMap2.put("layout_constraintEnd_toEndOf", "layout_marginEnd");
        hashMap2.put("layout_constraintLeft_toLeftOf", "layout_marginLeft");
        hashMap2.put("layout_constraintLeft_toRightOf", "layout_marginLeft");
        hashMap2.put("layout_constraintRight_toRightOf", "layout_marginRight");
        hashMap2.put("layout_constraintRight_toLeftOf", "layout_marginRight");
    }

    public DesignTool(MotionLayout motionLayout) {
        this.f2695a = motionLayout;
    }

    /* renamed from: a */
    public static void m554a(int i, ConstraintSet constraintSet, View view, HashMap hashMap, int i2, int i3) {
        int i4;
        String str = (String) f2693f.get(Pair.create(Integer.valueOf(i2), Integer.valueOf(i3)));
        String str2 = (String) hashMap.get(str);
        if (str2 != null) {
            String str3 = (String) f2694g.get(str);
            if (str3 != null) {
                i4 = m555b(i, (String) hashMap.get(str3));
            } else {
                i4 = 0;
            }
            int i5 = i4;
            constraintSet.connect(view.getId(), i2, Integer.parseInt(str2), i3, i5);
        }
    }

    /* renamed from: b */
    public static int m555b(int i, String str) {
        int indexOf;
        if (str == null || (indexOf = str.indexOf(100)) == -1) {
            return 0;
        }
        return (int) ((Integer.valueOf(str.substring(0, indexOf)).intValue() * i) / 160.0f);
    }

    /* renamed from: c */
    public static void m556c(ConstraintSet constraintSet, View view, HashMap hashMap, int i) {
        String str;
        if (i == 1) {
            str = "layout_constraintVertical_bias";
        } else {
            str = "layout_constraintHorizontal_bias";
        }
        String str2 = (String) hashMap.get(str);
        if (str2 != null) {
            if (i == 0) {
                constraintSet.setHorizontalBias(view.getId(), Float.parseFloat(str2));
            } else if (i == 1) {
                constraintSet.setVerticalBias(view.getId(), Float.parseFloat(str2));
            }
        }
    }

    /* renamed from: d */
    public static void m557d(int i, ConstraintSet constraintSet, View view, HashMap hashMap, int i2) {
        String str;
        int i3;
        if (i2 == 1) {
            str = "layout_height";
        } else {
            str = "layout_width";
        }
        String str2 = (String) hashMap.get(str);
        if (str2 != null) {
            if (!str2.equalsIgnoreCase("wrap_content")) {
                i3 = m555b(i, str2);
            } else {
                i3 = -2;
            }
            if (i2 == 0) {
                constraintSet.constrainWidth(view.getId(), i3);
            } else {
                constraintSet.constrainHeight(view.getId(), i3);
            }
        }
    }

    public int designAccess(int i, String str, Object obj, float[] fArr, int i2, float[] fArr2, int i3) {
        MotionController motionController;
        View view = (View) obj;
        MotionLayout motionLayout = this.f2695a;
        if (i != 0) {
            if (motionLayout.f2878r == null || view == null || (motionController = (MotionController) motionLayout.f2827B.get(view)) == null) {
                return -1;
            }
        } else {
            motionController = null;
        }
        if (i == 0) {
            return 1;
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return -1;
                }
                motionLayout.f2878r.getDuration();
                SplineSet splineSet = (SplineSet) motionController.f2820y.get(str);
                if (splineSet == null) {
                    return -1;
                }
                for (int i4 = 0; i4 < fArr2.length; i4++) {
                    fArr2[i4] = splineSet.get(i4 / (fArr2.length - 1));
                }
                return fArr2.length;
            }
            int duration = motionLayout.f2878r.getDuration() / 16;
            motionController.m563a(null, fArr2);
            return duration;
        }
        int duration2 = motionLayout.f2878r.getDuration() / 16;
        motionController.m564b(fArr2, duration2);
        return duration2;
    }

    public void disableAutoTransition(boolean z) {
        MotionScene motionScene = this.f2695a.f2878r;
        if (motionScene != null) {
            motionScene.disableAutoTransition(z);
        }
    }

    public void dumpConstraintSet(String str) {
        int lookUpConstraintId;
        MotionLayout motionLayout = this.f2695a;
        if (motionLayout.f2878r == null) {
            motionLayout.f2878r = null;
        }
        MotionScene motionScene = motionLayout.f2878r;
        if (motionScene == null) {
            lookUpConstraintId = 0;
        } else {
            lookUpConstraintId = motionScene.lookUpConstraintId(str);
        }
        System.out.println(" dumping  " + str + " (" + lookUpConstraintId + ")");
        try {
            motionLayout.f2878r.m586b(lookUpConstraintId).dump(motionLayout.f2878r, new int[0]);
        } catch (Exception e) {
            Log.e("DesignTool", "Error while dumping: " + str + " (" + lookUpConstraintId + ")", e);
        }
    }

    public int getAnimationKeyFrames(Object obj, float[] fArr) {
        MotionLayout motionLayout = this.f2695a;
        MotionScene motionScene = motionLayout.f2878r;
        if (motionScene == null) {
            return -1;
        }
        int duration = motionScene.getDuration() / 16;
        MotionController motionController = (MotionController) motionLayout.f2827B.get(obj);
        if (motionController == null) {
            return 0;
        }
        motionController.m563a(null, fArr);
        return duration;
    }

    public int getAnimationPath(Object obj, float[] fArr, int i) {
        MotionLayout motionLayout = this.f2695a;
        if (motionLayout.f2878r == null) {
            return -1;
        }
        MotionController motionController = (MotionController) motionLayout.f2827B.get(obj);
        if (motionController == null) {
            return 0;
        }
        motionController.m564b(fArr, i);
        return i;
    }

    public void getAnimationRectangles(Object obj, float[] fArr) {
        MotionLayout motionLayout = this.f2695a;
        MotionScene motionScene = motionLayout.f2878r;
        if (motionScene == null) {
            return;
        }
        int duration = motionScene.getDuration() / 16;
        MotionController motionController = (MotionController) motionLayout.f2827B.get(obj);
        if (motionController == null) {
            return;
        }
        float f = 1.0f / (duration - 1);
        for (int i = 0; i < duration; i++) {
            motionController.f2805j[0].getPos(motionController.m565c(i * f, null), motionController.f2811p);
            motionController.f2801f.m5967d(motionController.f2810o, motionController.f2811p, fArr, i * 8);
        }
    }

    public String getEndState() {
        String lookUpConstraintName;
        MotionLayout motionLayout = this.f2695a;
        int endState = motionLayout.getEndState();
        if (this.f2699e == endState) {
            return this.f2697c;
        }
        MotionScene motionScene = motionLayout.f2878r;
        if (motionScene == null) {
            lookUpConstraintName = null;
        } else {
            lookUpConstraintName = motionScene.lookUpConstraintName(endState);
        }
        if (lookUpConstraintName != null) {
            this.f2697c = lookUpConstraintName;
            this.f2699e = endState;
        }
        return lookUpConstraintName;
    }

    public int getKeyFrameInfo(Object obj, int i, int[] iArr) {
        MotionController motionController = (MotionController) this.f2695a.f2827B.get((View) obj);
        if (motionController == null) {
            return 0;
        }
        return motionController.getKeyFrameInfo(i, iArr);
    }

    public float getKeyFramePosition(Object obj, int i, float f, float f2) {
        MotionController motionController;
        if (!(obj instanceof View) || (motionController = (MotionController) this.f2695a.f2827B.get((View) obj)) == null) {
            return RecyclerView.f7068F0;
        }
        return motionController.m567e(i, f, f2);
    }

    public int getKeyFramePositions(Object obj, int[] iArr, float[] fArr) {
        MotionController motionController = (MotionController) this.f2695a.f2827B.get((View) obj);
        if (motionController == null) {
            return 0;
        }
        return motionController.getKeyFramePositions(iArr, fArr);
    }

    public Object getKeyframe(int i, int i2, int i3) {
        MotionLayout motionLayout = this.f2695a;
        MotionScene motionScene = motionLayout.f2878r;
        if (motionScene == null) {
            return null;
        }
        motionLayout.getContext();
        return motionScene.m588e(i, i2, i3);
    }

    public Object getKeyframeAtLocation(Object obj, float f, float f2) {
        MotionController motionController;
        View view = (View) obj;
        MotionLayout motionLayout = this.f2695a;
        if (motionLayout.f2878r == null) {
            return -1;
        }
        if (view == null || (motionController = (MotionController) motionLayout.f2827B.get(view)) == null) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        int width = viewGroup.getWidth();
        int height = viewGroup.getHeight();
        RectF rectF = new RectF();
        lp1 lp1Var = motionController.f2801f;
        float f3 = lp1Var.f22612e;
        rectF.left = f3;
        float f4 = lp1Var.f22613f;
        rectF.top = f4;
        rectF.right = f3 + lp1Var.f22614g;
        rectF.bottom = f4 + lp1Var.f22615h;
        RectF rectF2 = new RectF();
        lp1 lp1Var2 = motionController.f2802g;
        float f5 = lp1Var2.f22612e;
        rectF2.left = f5;
        float f6 = lp1Var2.f22613f;
        rectF2.top = f6;
        rectF2.right = f5 + lp1Var2.f22614g;
        rectF2.bottom = f6 + lp1Var2.f22615h;
        Iterator it = motionController.f2818w.iterator();
        while (it.hasNext()) {
            Key key = (Key) it.next();
            if (key instanceof j71) {
                j71 j71Var = (j71) key;
                if (j71Var.intersects(width, height, rectF, rectF2, f, f2)) {
                    return j71Var;
                }
            }
        }
        return null;
    }

    public Boolean getPositionKeyframe(Object obj, Object obj2, float f, float f2, String[] strArr, float[] fArr) {
        if (obj instanceof j71) {
            j71 j71Var = (j71) obj;
            MotionLayout motionLayout = this.f2695a;
            View view = (View) obj2;
            MotionController motionController = (MotionController) motionLayout.f2827B.get(view);
            motionController.getClass();
            RectF rectF = new RectF();
            lp1 lp1Var = motionController.f2801f;
            float f3 = lp1Var.f22612e;
            rectF.left = f3;
            float f4 = lp1Var.f22613f;
            rectF.top = f4;
            rectF.right = f3 + lp1Var.f22614g;
            rectF.bottom = f4 + lp1Var.f22615h;
            RectF rectF2 = new RectF();
            lp1 lp1Var2 = motionController.f2802g;
            float f5 = lp1Var2.f22612e;
            rectF2.left = f5;
            float f6 = lp1Var2.f22613f;
            rectF2.top = f6;
            rectF2.right = f5 + lp1Var2.f22614g;
            rectF2.bottom = f6 + lp1Var2.f22615h;
            j71Var.positionAttributes(view, rectF, rectF2, f, f2, strArr, fArr);
            motionLayout.rebuildScene();
            motionLayout.f2843J = true;
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public float getProgress() {
        return this.f2695a.getProgress();
    }

    public String getStartState() {
        String lookUpConstraintName;
        MotionLayout motionLayout = this.f2695a;
        int startState = motionLayout.getStartState();
        if (this.f2698d == startState) {
            return this.f2696b;
        }
        MotionScene motionScene = motionLayout.f2878r;
        if (motionScene == null) {
            lookUpConstraintName = null;
        } else {
            lookUpConstraintName = motionScene.lookUpConstraintName(startState);
        }
        if (lookUpConstraintName != null) {
            this.f2696b = lookUpConstraintName;
            this.f2698d = startState;
        }
        MotionScene motionScene2 = motionLayout.f2878r;
        if (motionScene2 == null) {
            return null;
        }
        return motionScene2.lookUpConstraintName(startState);
    }

    public String getState() {
        if (this.f2696b != null && this.f2697c != null) {
            float progress = getProgress();
            if (progress <= 0.01f) {
                return this.f2696b;
            }
            if (progress >= 0.99f) {
                return this.f2697c;
            }
        }
        return this.f2696b;
    }

    public long getTransitionTimeMs() {
        return this.f2695a.getTransitionTimeMs();
    }

    public boolean isInTransition() {
        if (this.f2696b != null && this.f2697c != null) {
            return true;
        }
        return false;
    }

    public void setAttributes(int i, String str, Object obj, Object obj2) {
        HashMap hashMap;
        int lookUpConstraintId;
        View view = (View) obj;
        if (obj2 instanceof HashMap) {
            hashMap = (HashMap) obj2;
        } else {
            hashMap = new HashMap();
        }
        MotionLayout motionLayout = this.f2695a;
        MotionScene motionScene = motionLayout.f2878r;
        if (motionScene == null) {
            lookUpConstraintId = 0;
        } else {
            lookUpConstraintId = motionScene.lookUpConstraintId(str);
        }
        ConstraintSet m586b = motionLayout.f2878r.m586b(lookUpConstraintId);
        if (m586b == null) {
            return;
        }
        m586b.clear(view.getId());
        m557d(i, m586b, view, hashMap, 0);
        m557d(i, m586b, view, hashMap, 1);
        HashMap hashMap2 = hashMap;
        m554a(i, m586b, view, hashMap2, 6, 6);
        m554a(i, m586b, view, hashMap2, 6, 7);
        m554a(i, m586b, view, hashMap2, 7, 7);
        m554a(i, m586b, view, hashMap2, 7, 6);
        m554a(i, m586b, view, hashMap2, 1, 1);
        m554a(i, m586b, view, hashMap2, 1, 2);
        m554a(i, m586b, view, hashMap2, 2, 2);
        m554a(i, m586b, view, hashMap2, 2, 1);
        m554a(i, m586b, view, hashMap2, 3, 3);
        m554a(i, m586b, view, hashMap2, 3, 4);
        m554a(i, m586b, view, hashMap2, 4, 3);
        m554a(i, m586b, view, hashMap2, 4, 4);
        m554a(i, m586b, view, hashMap2, 5, 5);
        m556c(m586b, view, hashMap, 0);
        m556c(m586b, view, hashMap, 1);
        String str2 = (String) hashMap.get("layout_editor_absoluteX");
        if (str2 != null) {
            m586b.setEditorAbsoluteX(view.getId(), m555b(i, str2));
        }
        String str3 = (String) hashMap.get("layout_editor_absoluteY");
        if (str3 != null) {
            m586b.setEditorAbsoluteY(view.getId(), m555b(i, str3));
        }
        motionLayout.updateState(lookUpConstraintId, m586b);
        motionLayout.requestLayout();
    }

    public void setKeyFrame(Object obj, int i, String str, Object obj2) {
        MotionLayout motionLayout = this.f2695a;
        MotionScene motionScene = motionLayout.f2878r;
        if (motionScene != null) {
            motionScene.setKeyframe((View) obj, i, str, obj2);
            motionLayout.f2839H = i / 100.0f;
            motionLayout.f2835F = RecyclerView.f7068F0;
            motionLayout.rebuildScene();
            motionLayout.m577j(true);
        }
    }

    public boolean setKeyFramePosition(Object obj, int i, int i2, float f, float f2) {
        if (!(obj instanceof View)) {
            return false;
        }
        MotionLayout motionLayout = this.f2695a;
        if (motionLayout.f2878r != null) {
            MotionController motionController = (MotionController) motionLayout.f2827B.get(obj);
            int i3 = (int) (motionLayout.f2833E * 100.0f);
            if (motionController != null) {
                View view = (View) obj;
                MotionScene.Transition transition = motionLayout.f2878r.f2898c;
                if (transition != null) {
                    Iterator it = transition.f2926k.iterator();
                    while (it.hasNext()) {
                        Iterator<Key> it2 = ((KeyFrames) it.next()).getKeyFramesForView(view.getId()).iterator();
                        while (it2.hasNext()) {
                            if (it2.next().f2700a == i3) {
                                float m567e = motionController.m567e(2, f, f2);
                                float m567e2 = motionController.m567e(5, f, f2);
                                motionLayout.f2878r.setKeyframe(view, i3, "motion:percentX", Float.valueOf(m567e));
                                motionLayout.f2878r.setKeyframe(view, i3, "motion:percentY", Float.valueOf(m567e2));
                                motionLayout.rebuildScene();
                                motionLayout.m577j(true);
                                motionLayout.invalidate();
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public void setKeyframe(Object obj, String str, Object obj2) {
        if (obj instanceof Key) {
            ((Key) obj).setValue(str, obj2);
            MotionLayout motionLayout = this.f2695a;
            motionLayout.rebuildScene();
            motionLayout.f2843J = true;
        }
    }

    public void setState(String str) {
        int lookUpConstraintId;
        if (str == null) {
            str = "motion_base";
        }
        if (Objects.equals(this.f2696b, str)) {
            return;
        }
        this.f2696b = str;
        this.f2697c = null;
        MotionLayout motionLayout = this.f2695a;
        if (motionLayout.f2878r == null) {
            motionLayout.f2878r = null;
        }
        MotionScene motionScene = motionLayout.f2878r;
        if (motionScene == null) {
            lookUpConstraintId = 0;
        } else {
            lookUpConstraintId = motionScene.lookUpConstraintId(str);
        }
        this.f2698d = lookUpConstraintId;
        if (lookUpConstraintId != 0) {
            if (lookUpConstraintId == motionLayout.getStartState()) {
                motionLayout.setProgress(RecyclerView.f7068F0);
            } else if (lookUpConstraintId == motionLayout.getEndState()) {
                motionLayout.setProgress(1.0f);
            } else {
                motionLayout.transitionToState(lookUpConstraintId);
                motionLayout.setProgress(1.0f);
            }
        }
        motionLayout.requestLayout();
    }

    public void setToolPosition(float f) {
        MotionLayout motionLayout = this.f2695a;
        if (motionLayout.f2878r == null) {
            motionLayout.f2878r = null;
        }
        motionLayout.setProgress(f);
        motionLayout.m577j(true);
        motionLayout.requestLayout();
        motionLayout.invalidate();
    }

    public void setTransition(String str, String str2) {
        int lookUpConstraintId;
        MotionLayout motionLayout = this.f2695a;
        if (motionLayout.f2878r == null) {
            motionLayout.f2878r = null;
        }
        MotionScene motionScene = motionLayout.f2878r;
        int i = 0;
        if (motionScene == null) {
            lookUpConstraintId = 0;
        } else {
            lookUpConstraintId = motionScene.lookUpConstraintId(str);
        }
        MotionScene motionScene2 = motionLayout.f2878r;
        if (motionScene2 != null) {
            i = motionScene2.lookUpConstraintId(str2);
        }
        motionLayout.setTransition(lookUpConstraintId, i);
        this.f2698d = lookUpConstraintId;
        this.f2699e = i;
        this.f2696b = str;
        this.f2697c = str2;
    }

    public void setViewDebug(Object obj, int i) {
        if (!(obj instanceof View)) {
            return;
        }
        MotionLayout motionLayout = this.f2695a;
        MotionController motionController = (MotionController) motionLayout.f2827B.get(obj);
        if (motionController != null) {
            motionController.setDrawPath(i);
            motionLayout.invalidate();
        }
    }

    public Object getKeyframe(Object obj, int i, int i2) {
        MotionLayout motionLayout = this.f2695a;
        if (motionLayout.f2878r == null) {
            return null;
        }
        int id = ((View) obj).getId();
        MotionScene motionScene = motionLayout.f2878r;
        motionLayout.getContext();
        return motionScene.m588e(i, id, i2);
    }
}
