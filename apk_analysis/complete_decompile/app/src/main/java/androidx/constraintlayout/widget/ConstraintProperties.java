package androidx.constraintlayout.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class ConstraintProperties {
    public static final int BASELINE = 5;
    public static final int BOTTOM = 4;
    public static final int END = 7;
    public static final int LEFT = 1;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    public static final int PARENT_ID = 0;
    public static final int RIGHT = 2;
    public static final int START = 6;
    public static final int TOP = 3;
    public static final int UNSET = -1;
    public static final int WRAP_CONTENT = -2;

    /* renamed from: a */
    public final ConstraintLayout.LayoutParams f3181a;

    /* renamed from: b */
    public final View f3182b;

    public ConstraintProperties(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            this.f3181a = (ConstraintLayout.LayoutParams) layoutParams;
            this.f3182b = view;
            return;
        }
        throw new RuntimeException("Only children of ConstraintLayout.LayoutParams supported");
    }

    /* renamed from: a */
    public static String m641a(int i) {
        switch (i) {
            case 1:
                return "left";
            case 2:
                return "right";
            case 3:
                return "top";
            case 4:
                return "bottom";
            case 5:
                return "baseline";
            case 6:
                return "start";
            case 7:
                return "end";
            default:
                return "undefined";
        }
    }

    public ConstraintProperties addToHorizontalChain(int i, int i2) {
        int i3;
        int i4;
        if (i == 0) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        connect(1, i, i3, 0);
        if (i2 == 0) {
            i4 = 2;
        } else {
            i4 = 1;
        }
        connect(2, i2, i4, 0);
        View view = this.f3182b;
        if (i != 0) {
            new ConstraintProperties(((ViewGroup) view.getParent()).findViewById(i)).connect(2, view.getId(), 1, 0);
        }
        if (i2 != 0) {
            new ConstraintProperties(((ViewGroup) view.getParent()).findViewById(i2)).connect(1, view.getId(), 2, 0);
        }
        return this;
    }

    public ConstraintProperties addToHorizontalChainRTL(int i, int i2) {
        int i3;
        int i4;
        if (i == 0) {
            i3 = 6;
        } else {
            i3 = 7;
        }
        connect(6, i, i3, 0);
        if (i2 == 0) {
            i4 = 7;
        } else {
            i4 = 6;
        }
        connect(7, i2, i4, 0);
        View view = this.f3182b;
        if (i != 0) {
            new ConstraintProperties(((ViewGroup) view.getParent()).findViewById(i)).connect(7, view.getId(), 6, 0);
        }
        if (i2 != 0) {
            new ConstraintProperties(((ViewGroup) view.getParent()).findViewById(i2)).connect(6, view.getId(), 7, 0);
        }
        return this;
    }

    public ConstraintProperties addToVerticalChain(int i, int i2) {
        int i3;
        int i4;
        if (i == 0) {
            i3 = 3;
        } else {
            i3 = 4;
        }
        connect(3, i, i3, 0);
        if (i2 == 0) {
            i4 = 4;
        } else {
            i4 = 3;
        }
        connect(4, i2, i4, 0);
        View view = this.f3182b;
        if (i != 0) {
            new ConstraintProperties(((ViewGroup) view.getParent()).findViewById(i)).connect(4, view.getId(), 3, 0);
        }
        if (i2 != 0) {
            new ConstraintProperties(((ViewGroup) view.getParent()).findViewById(i2)).connect(3, view.getId(), 4, 0);
        }
        return this;
    }

    public ConstraintProperties alpha(float f) {
        this.f3182b.setAlpha(f);
        return this;
    }

    public void apply() {
    }

    public ConstraintProperties center(int i, int i2, int i3, int i4, int i5, int i6, float f) {
        if (i3 >= 0) {
            if (i6 >= 0) {
                if (f > RecyclerView.f7068F0 && f <= 1.0f) {
                    ConstraintLayout.LayoutParams layoutParams = this.f3181a;
                    if (i2 != 1 && i2 != 2) {
                        if (i2 != 6 && i2 != 7) {
                            connect(3, i, i2, i3);
                            connect(4, i4, i5, i6);
                            layoutParams.verticalBias = f;
                        } else {
                            connect(6, i, i2, i3);
                            connect(7, i4, i5, i6);
                            layoutParams.horizontalBias = f;
                        }
                    } else {
                        connect(1, i, i2, i3);
                        connect(2, i4, i5, i6);
                        layoutParams.horizontalBias = f;
                    }
                    return this;
                }
                throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
            }
            throw new IllegalArgumentException("margin must be > 0");
        }
        throw new IllegalArgumentException("margin must be > 0");
    }

    public ConstraintProperties centerHorizontally(int i, int i2, int i3, int i4, int i5, int i6, float f) {
        connect(1, i, i2, i3);
        connect(2, i4, i5, i6);
        this.f3181a.horizontalBias = f;
        return this;
    }

    public ConstraintProperties centerHorizontallyRtl(int i, int i2, int i3, int i4, int i5, int i6, float f) {
        connect(6, i, i2, i3);
        connect(7, i4, i5, i6);
        this.f3181a.horizontalBias = f;
        return this;
    }

    public ConstraintProperties centerVertically(int i, int i2, int i3, int i4, int i5, int i6, float f) {
        connect(3, i, i2, i3);
        connect(4, i4, i5, i6);
        this.f3181a.verticalBias = f;
        return this;
    }

    public ConstraintProperties connect(int i, int i2, int i3, int i4) {
        ConstraintLayout.LayoutParams layoutParams = this.f3181a;
        switch (i) {
            case 1:
                if (i3 == 1) {
                    layoutParams.leftToLeft = i2;
                    layoutParams.leftToRight = -1;
                } else if (i3 == 2) {
                    layoutParams.leftToRight = i2;
                    layoutParams.leftToLeft = -1;
                } else {
                    throw new IllegalArgumentException("Left to " + m641a(i3) + " undefined");
                }
                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = i4;
                return this;
            case 2:
                if (i3 == 1) {
                    layoutParams.rightToLeft = i2;
                    layoutParams.rightToRight = -1;
                } else if (i3 == 2) {
                    layoutParams.rightToRight = i2;
                    layoutParams.rightToLeft = -1;
                } else {
                    throw new IllegalArgumentException("right to " + m641a(i3) + " undefined");
                }
                ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = i4;
                return this;
            case 3:
                if (i3 == 3) {
                    layoutParams.topToTop = i2;
                    layoutParams.topToBottom = -1;
                    layoutParams.baselineToBaseline = -1;
                    layoutParams.baselineToTop = -1;
                    layoutParams.baselineToBottom = -1;
                } else if (i3 == 4) {
                    layoutParams.topToBottom = i2;
                    layoutParams.topToTop = -1;
                    layoutParams.baselineToBaseline = -1;
                    layoutParams.baselineToTop = -1;
                    layoutParams.baselineToBottom = -1;
                } else {
                    throw new IllegalArgumentException("right to " + m641a(i3) + " undefined");
                }
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = i4;
                return this;
            case 4:
                if (i3 == 4) {
                    layoutParams.bottomToBottom = i2;
                    layoutParams.bottomToTop = -1;
                    layoutParams.baselineToBaseline = -1;
                    layoutParams.baselineToTop = -1;
                    layoutParams.baselineToBottom = -1;
                } else if (i3 == 3) {
                    layoutParams.bottomToTop = i2;
                    layoutParams.bottomToBottom = -1;
                    layoutParams.baselineToBaseline = -1;
                    layoutParams.baselineToTop = -1;
                    layoutParams.baselineToBottom = -1;
                } else {
                    throw new IllegalArgumentException("right to " + m641a(i3) + " undefined");
                }
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = i4;
                return this;
            case 5:
                if (i3 == 5) {
                    layoutParams.baselineToBaseline = i2;
                    layoutParams.bottomToBottom = -1;
                    layoutParams.bottomToTop = -1;
                    layoutParams.topToTop = -1;
                    layoutParams.topToBottom = -1;
                } else if (i3 == 3) {
                    layoutParams.baselineToTop = i2;
                    layoutParams.bottomToBottom = -1;
                    layoutParams.bottomToTop = -1;
                    layoutParams.topToTop = -1;
                    layoutParams.topToBottom = -1;
                } else if (i3 == 4) {
                    layoutParams.baselineToBottom = i2;
                    layoutParams.bottomToBottom = -1;
                    layoutParams.bottomToTop = -1;
                    layoutParams.topToTop = -1;
                    layoutParams.topToBottom = -1;
                } else {
                    throw new IllegalArgumentException("right to " + m641a(i3) + " undefined");
                }
                layoutParams.baselineMargin = i4;
                return this;
            case 6:
                if (i3 == 6) {
                    layoutParams.startToStart = i2;
                    layoutParams.startToEnd = -1;
                } else if (i3 == 7) {
                    layoutParams.startToEnd = i2;
                    layoutParams.startToStart = -1;
                } else {
                    throw new IllegalArgumentException("right to " + m641a(i3) + " undefined");
                }
                layoutParams.setMarginStart(i4);
                return this;
            case 7:
                if (i3 == 7) {
                    layoutParams.endToEnd = i2;
                    layoutParams.endToStart = -1;
                } else if (i3 == 6) {
                    layoutParams.endToStart = i2;
                    layoutParams.endToEnd = -1;
                } else {
                    throw new IllegalArgumentException("right to " + m641a(i3) + " undefined");
                }
                layoutParams.setMarginEnd(i4);
                return this;
            default:
                throw new IllegalArgumentException(m641a(i) + " to " + m641a(i3) + " unknown");
        }
    }

    public ConstraintProperties constrainDefaultHeight(int i) {
        this.f3181a.matchConstraintDefaultHeight = i;
        return this;
    }

    public ConstraintProperties constrainDefaultWidth(int i) {
        this.f3181a.matchConstraintDefaultWidth = i;
        return this;
    }

    public ConstraintProperties constrainHeight(int i) {
        ((ViewGroup.MarginLayoutParams) this.f3181a).height = i;
        return this;
    }

    public ConstraintProperties constrainMaxHeight(int i) {
        this.f3181a.matchConstraintMaxHeight = i;
        return this;
    }

    public ConstraintProperties constrainMaxWidth(int i) {
        this.f3181a.matchConstraintMaxWidth = i;
        return this;
    }

    public ConstraintProperties constrainMinHeight(int i) {
        this.f3181a.matchConstraintMinHeight = i;
        return this;
    }

    public ConstraintProperties constrainMinWidth(int i) {
        this.f3181a.matchConstraintMinWidth = i;
        return this;
    }

    public ConstraintProperties constrainWidth(int i) {
        ((ViewGroup.MarginLayoutParams) this.f3181a).width = i;
        return this;
    }

    public ConstraintProperties dimensionRatio(String str) {
        this.f3181a.dimensionRatio = str;
        return this;
    }

    public ConstraintProperties elevation(float f) {
        this.f3182b.setElevation(f);
        return this;
    }

    public ConstraintProperties goneMargin(int i, int i2) {
        ConstraintLayout.LayoutParams layoutParams = this.f3181a;
        switch (i) {
            case 1:
                layoutParams.goneLeftMargin = i2;
                return this;
            case 2:
                layoutParams.goneRightMargin = i2;
                return this;
            case 3:
                layoutParams.goneTopMargin = i2;
                return this;
            case 4:
                layoutParams.goneBottomMargin = i2;
                return this;
            case 5:
                throw new IllegalArgumentException("baseline does not support margins");
            case 6:
                layoutParams.goneStartMargin = i2;
                return this;
            case 7:
                layoutParams.goneEndMargin = i2;
                return this;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public ConstraintProperties horizontalBias(float f) {
        this.f3181a.horizontalBias = f;
        return this;
    }

    public ConstraintProperties horizontalChainStyle(int i) {
        this.f3181a.horizontalChainStyle = i;
        return this;
    }

    public ConstraintProperties horizontalWeight(float f) {
        this.f3181a.horizontalWeight = f;
        return this;
    }

    public ConstraintProperties margin(int i, int i2) {
        ConstraintLayout.LayoutParams layoutParams = this.f3181a;
        switch (i) {
            case 1:
                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = i2;
                return this;
            case 2:
                ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = i2;
                return this;
            case 3:
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = i2;
                return this;
            case 4:
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = i2;
                return this;
            case 5:
                throw new IllegalArgumentException("baseline does not support margins");
            case 6:
                layoutParams.setMarginStart(i2);
                return this;
            case 7:
                layoutParams.setMarginEnd(i2);
                return this;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public ConstraintProperties removeConstraints(int i) {
        ConstraintLayout.LayoutParams layoutParams = this.f3181a;
        switch (i) {
            case 1:
                layoutParams.leftToRight = -1;
                layoutParams.leftToLeft = -1;
                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = -1;
                layoutParams.goneLeftMargin = Integer.MIN_VALUE;
                return this;
            case 2:
                layoutParams.rightToRight = -1;
                layoutParams.rightToLeft = -1;
                ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = -1;
                layoutParams.goneRightMargin = Integer.MIN_VALUE;
                return this;
            case 3:
                layoutParams.topToBottom = -1;
                layoutParams.topToTop = -1;
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = -1;
                layoutParams.goneTopMargin = Integer.MIN_VALUE;
                return this;
            case 4:
                layoutParams.bottomToTop = -1;
                layoutParams.bottomToBottom = -1;
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = -1;
                layoutParams.goneBottomMargin = Integer.MIN_VALUE;
                return this;
            case 5:
                layoutParams.baselineToBaseline = -1;
                return this;
            case 6:
                layoutParams.startToEnd = -1;
                layoutParams.startToStart = -1;
                layoutParams.setMarginStart(-1);
                layoutParams.goneStartMargin = Integer.MIN_VALUE;
                return this;
            case 7:
                layoutParams.endToStart = -1;
                layoutParams.endToEnd = -1;
                layoutParams.setMarginEnd(-1);
                layoutParams.goneEndMargin = Integer.MIN_VALUE;
                return this;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public ConstraintProperties removeFromHorizontalChain() {
        ConstraintLayout.LayoutParams layoutParams = this.f3181a;
        int i = layoutParams.leftToRight;
        int i2 = layoutParams.rightToLeft;
        View view = this.f3182b;
        if (i == -1 && i2 == -1) {
            int i3 = layoutParams.startToEnd;
            int i4 = layoutParams.endToStart;
            if (i3 != -1 || i4 != -1) {
                ConstraintProperties constraintProperties = new ConstraintProperties(((ViewGroup) view.getParent()).findViewById(i3));
                ConstraintProperties constraintProperties2 = new ConstraintProperties(((ViewGroup) view.getParent()).findViewById(i4));
                if (i3 != -1 && i4 != -1) {
                    constraintProperties.connect(7, i4, 6, 0);
                    constraintProperties2.connect(6, i, 7, 0);
                } else if (i != -1 || i4 != -1) {
                    int i5 = layoutParams.rightToRight;
                    if (i5 != -1) {
                        constraintProperties.connect(7, i5, 7, 0);
                    } else {
                        int i6 = layoutParams.leftToLeft;
                        if (i6 != -1) {
                            constraintProperties2.connect(6, i6, 6, 0);
                        }
                    }
                }
            }
            removeConstraints(6);
            removeConstraints(7);
        } else {
            ConstraintProperties constraintProperties3 = new ConstraintProperties(((ViewGroup) view.getParent()).findViewById(i));
            ConstraintProperties constraintProperties4 = new ConstraintProperties(((ViewGroup) view.getParent()).findViewById(i2));
            if (i != -1 && i2 != -1) {
                constraintProperties3.connect(2, i2, 1, 0);
                constraintProperties4.connect(1, i, 2, 0);
            } else if (i != -1 || i2 != -1) {
                int i7 = layoutParams.rightToRight;
                if (i7 != -1) {
                    constraintProperties3.connect(2, i7, 2, 0);
                } else {
                    int i8 = layoutParams.leftToLeft;
                    if (i8 != -1) {
                        constraintProperties4.connect(1, i8, 1, 0);
                    }
                }
            }
            removeConstraints(1);
            removeConstraints(2);
        }
        return this;
    }

    public ConstraintProperties removeFromVerticalChain() {
        ConstraintLayout.LayoutParams layoutParams = this.f3181a;
        int i = layoutParams.topToBottom;
        int i2 = layoutParams.bottomToTop;
        if (i != -1 || i2 != -1) {
            View view = this.f3182b;
            ConstraintProperties constraintProperties = new ConstraintProperties(((ViewGroup) view.getParent()).findViewById(i));
            ConstraintProperties constraintProperties2 = new ConstraintProperties(((ViewGroup) view.getParent()).findViewById(i2));
            if (i != -1 && i2 != -1) {
                constraintProperties.connect(4, i2, 3, 0);
                constraintProperties2.connect(3, i, 4, 0);
            } else if (i != -1 || i2 != -1) {
                int i3 = layoutParams.bottomToBottom;
                if (i3 != -1) {
                    constraintProperties.connect(4, i3, 4, 0);
                } else {
                    int i4 = layoutParams.topToTop;
                    if (i4 != -1) {
                        constraintProperties2.connect(3, i4, 3, 0);
                    }
                }
            }
        }
        removeConstraints(3);
        removeConstraints(4);
        return this;
    }

    public ConstraintProperties rotation(float f) {
        this.f3182b.setRotation(f);
        return this;
    }

    public ConstraintProperties rotationX(float f) {
        this.f3182b.setRotationX(f);
        return this;
    }

    public ConstraintProperties rotationY(float f) {
        this.f3182b.setRotationY(f);
        return this;
    }

    public ConstraintProperties scaleX(float f) {
        this.f3182b.setScaleY(f);
        return this;
    }

    public ConstraintProperties scaleY(float f) {
        return this;
    }

    public ConstraintProperties transformPivot(float f, float f2) {
        View view = this.f3182b;
        view.setPivotX(f);
        view.setPivotY(f2);
        return this;
    }

    public ConstraintProperties transformPivotX(float f) {
        this.f3182b.setPivotX(f);
        return this;
    }

    public ConstraintProperties transformPivotY(float f) {
        this.f3182b.setPivotY(f);
        return this;
    }

    public ConstraintProperties translation(float f, float f2) {
        View view = this.f3182b;
        view.setTranslationX(f);
        view.setTranslationY(f2);
        return this;
    }

    public ConstraintProperties translationX(float f) {
        this.f3182b.setTranslationX(f);
        return this;
    }

    public ConstraintProperties translationY(float f) {
        this.f3182b.setTranslationY(f);
        return this;
    }

    public ConstraintProperties translationZ(float f) {
        this.f3182b.setTranslationZ(f);
        return this;
    }

    public ConstraintProperties verticalBias(float f) {
        this.f3181a.verticalBias = f;
        return this;
    }

    public ConstraintProperties verticalChainStyle(int i) {
        this.f3181a.verticalChainStyle = i;
        return this;
    }

    public ConstraintProperties verticalWeight(float f) {
        this.f3181a.verticalWeight = f;
        return this;
    }

    public ConstraintProperties visibility(int i) {
        this.f3182b.setVisibility(i);
        return this;
    }

    public ConstraintProperties centerHorizontally(int i) {
        if (i == 0) {
            center(0, 1, 0, 0, 2, 0, 0.5f);
        } else {
            center(i, 2, 0, i, 1, 0, 0.5f);
        }
        return this;
    }

    public ConstraintProperties centerHorizontallyRtl(int i) {
        if (i == 0) {
            center(0, 6, 0, 0, 7, 0, 0.5f);
        } else {
            center(i, 7, 0, i, 6, 0, 0.5f);
        }
        return this;
    }

    public ConstraintProperties centerVertically(int i) {
        if (i == 0) {
            center(0, 3, 0, 0, 4, 0, 0.5f);
        } else {
            center(i, 4, 0, i, 3, 0, 0.5f);
        }
        return this;
    }
}
