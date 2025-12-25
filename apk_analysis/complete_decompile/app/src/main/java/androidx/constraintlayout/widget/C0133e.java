package androidx.constraintlayout.widget;

import android.util.Log;
import androidx.constraintlayout.widget.ConstraintSet;
import java.util.Arrays;

/* renamed from: androidx.constraintlayout.widget.e */
/* loaded from: classes.dex */
public final class C0133e {

    /* renamed from: a */
    public int[] f3233a;

    /* renamed from: b */
    public int[] f3234b;

    /* renamed from: c */
    public int f3235c;

    /* renamed from: d */
    public int[] f3236d;

    /* renamed from: e */
    public float[] f3237e;

    /* renamed from: f */
    public int f3238f;

    /* renamed from: g */
    public int[] f3239g;

    /* renamed from: h */
    public String[] f3240h;

    /* renamed from: i */
    public int f3241i;

    /* renamed from: j */
    public int[] f3242j;

    /* renamed from: k */
    public boolean[] f3243k;

    /* renamed from: l */
    public int f3244l;

    /* renamed from: a */
    public final void m665a(int i, float f) {
        int i2 = this.f3238f;
        int[] iArr = this.f3236d;
        if (i2 >= iArr.length) {
            this.f3236d = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.f3237e;
            this.f3237e = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.f3236d;
        int i3 = this.f3238f;
        iArr2[i3] = i;
        float[] fArr2 = this.f3237e;
        this.f3238f = i3 + 1;
        fArr2[i3] = f;
    }

    /* renamed from: b */
    public final void m666b(int i, int i2) {
        int i3 = this.f3235c;
        int[] iArr = this.f3233a;
        if (i3 >= iArr.length) {
            this.f3233a = Arrays.copyOf(iArr, iArr.length * 2);
            int[] iArr2 = this.f3234b;
            this.f3234b = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.f3233a;
        int i4 = this.f3235c;
        iArr3[i4] = i;
        int[] iArr4 = this.f3234b;
        this.f3235c = i4 + 1;
        iArr4[i4] = i2;
    }

    /* renamed from: c */
    public final void m667c(int i, String str) {
        int i2 = this.f3241i;
        int[] iArr = this.f3239g;
        if (i2 >= iArr.length) {
            this.f3239g = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.f3240h;
            this.f3240h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
        }
        int[] iArr2 = this.f3239g;
        int i3 = this.f3241i;
        iArr2[i3] = i;
        String[] strArr2 = this.f3240h;
        this.f3241i = i3 + 1;
        strArr2[i3] = str;
    }

    /* renamed from: d */
    public final void m668d(int i, boolean z) {
        int i2 = this.f3244l;
        int[] iArr = this.f3242j;
        if (i2 >= iArr.length) {
            this.f3242j = Arrays.copyOf(iArr, iArr.length * 2);
            boolean[] zArr = this.f3243k;
            this.f3243k = Arrays.copyOf(zArr, zArr.length * 2);
        }
        int[] iArr2 = this.f3242j;
        int i3 = this.f3244l;
        iArr2[i3] = i;
        boolean[] zArr2 = this.f3243k;
        this.f3244l = i3 + 1;
        zArr2[i3] = z;
    }

    /* renamed from: e */
    public final void m669e(ConstraintSet.Constraint constraint) {
        for (int i = 0; i < this.f3235c; i++) {
            int i2 = this.f3233a[i];
            int i3 = this.f3234b[i];
            int i4 = ConstraintSet.ROTATE_NONE;
            if (i2 != 6) {
                if (i2 != 7) {
                    if (i2 != 8) {
                        if (i2 != 27) {
                            if (i2 != 28) {
                                if (i2 != 41) {
                                    if (i2 != 42) {
                                        if (i2 != 61) {
                                            if (i2 != 62) {
                                                if (i2 != 72) {
                                                    if (i2 != 73) {
                                                        if (i2 != 2) {
                                                            if (i2 != 31) {
                                                                if (i2 != 34) {
                                                                    if (i2 != 38) {
                                                                        if (i2 != 64) {
                                                                            if (i2 != 66) {
                                                                                if (i2 != 76) {
                                                                                    if (i2 != 78) {
                                                                                        if (i2 != 97) {
                                                                                            if (i2 != 93) {
                                                                                                if (i2 != 94) {
                                                                                                    switch (i2) {
                                                                                                        case 11:
                                                                                                            constraint.layout.goneBottomMargin = i3;
                                                                                                            break;
                                                                                                        case 12:
                                                                                                            constraint.layout.goneEndMargin = i3;
                                                                                                            break;
                                                                                                        case 13:
                                                                                                            constraint.layout.goneLeftMargin = i3;
                                                                                                            break;
                                                                                                        case 14:
                                                                                                            constraint.layout.goneRightMargin = i3;
                                                                                                            break;
                                                                                                        case 15:
                                                                                                            constraint.layout.goneStartMargin = i3;
                                                                                                            break;
                                                                                                        case 16:
                                                                                                            constraint.layout.goneTopMargin = i3;
                                                                                                            break;
                                                                                                        case 17:
                                                                                                            constraint.layout.guideBegin = i3;
                                                                                                            break;
                                                                                                        case 18:
                                                                                                            constraint.layout.guideEnd = i3;
                                                                                                            break;
                                                                                                        default:
                                                                                                            switch (i2) {
                                                                                                                case 21:
                                                                                                                    constraint.layout.mHeight = i3;
                                                                                                                    break;
                                                                                                                case 22:
                                                                                                                    constraint.propertySet.visibility = i3;
                                                                                                                    break;
                                                                                                                case 23:
                                                                                                                    constraint.layout.mWidth = i3;
                                                                                                                    break;
                                                                                                                case 24:
                                                                                                                    constraint.layout.leftMargin = i3;
                                                                                                                    break;
                                                                                                                default:
                                                                                                                    switch (i2) {
                                                                                                                        case 54:
                                                                                                                            constraint.layout.widthDefault = i3;
                                                                                                                            break;
                                                                                                                        case 55:
                                                                                                                            constraint.layout.heightDefault = i3;
                                                                                                                            break;
                                                                                                                        case 56:
                                                                                                                            constraint.layout.widthMax = i3;
                                                                                                                            break;
                                                                                                                        case 57:
                                                                                                                            constraint.layout.heightMax = i3;
                                                                                                                            break;
                                                                                                                        case 58:
                                                                                                                            constraint.layout.widthMin = i3;
                                                                                                                            break;
                                                                                                                        case 59:
                                                                                                                            constraint.layout.heightMin = i3;
                                                                                                                            break;
                                                                                                                        default:
                                                                                                                            switch (i2) {
                                                                                                                                case 82:
                                                                                                                                    constraint.motion.mAnimateCircleAngleTo = i3;
                                                                                                                                    break;
                                                                                                                                case 83:
                                                                                                                                    constraint.transform.transformPivotTarget = i3;
                                                                                                                                    break;
                                                                                                                                case 84:
                                                                                                                                    constraint.motion.mQuantizeMotionSteps = i3;
                                                                                                                                    break;
                                                                                                                                default:
                                                                                                                                    switch (i2) {
                                                                                                                                        case 87:
                                                                                                                                            break;
                                                                                                                                        case 88:
                                                                                                                                            constraint.motion.mQuantizeInterpolatorType = i3;
                                                                                                                                            break;
                                                                                                                                        case 89:
                                                                                                                                            constraint.motion.mQuantizeInterpolatorID = i3;
                                                                                                                                            break;
                                                                                                                                        default:
                                                                                                                                            Log.w("ConstraintSet", "Unknown attribute 0x");
                                                                                                                                            break;
                                                                                                                                    }
                                                                                                                            }
                                                                                                                    }
                                                                                                            }
                                                                                                    }
                                                                                                } else {
                                                                                                    constraint.layout.goneBaselineMargin = i3;
                                                                                                }
                                                                                            } else {
                                                                                                constraint.layout.baselineMargin = i3;
                                                                                            }
                                                                                        } else {
                                                                                            constraint.layout.mWrapBehavior = i3;
                                                                                        }
                                                                                    } else {
                                                                                        constraint.propertySet.mVisibilityMode = i3;
                                                                                    }
                                                                                } else {
                                                                                    constraint.motion.mPathMotionArc = i3;
                                                                                }
                                                                            } else {
                                                                                constraint.motion.mDrawPath = i3;
                                                                            }
                                                                        } else {
                                                                            constraint.motion.mAnimateRelativeTo = i3;
                                                                        }
                                                                    } else {
                                                                        constraint.f3191a = i3;
                                                                    }
                                                                } else {
                                                                    constraint.layout.topMargin = i3;
                                                                }
                                                            } else {
                                                                constraint.layout.startMargin = i3;
                                                            }
                                                        } else {
                                                            constraint.layout.bottomMargin = i3;
                                                        }
                                                    } else {
                                                        constraint.layout.mBarrierMargin = i3;
                                                    }
                                                } else {
                                                    constraint.layout.mBarrierDirection = i3;
                                                }
                                            } else {
                                                constraint.layout.circleRadius = i3;
                                            }
                                        } else {
                                            constraint.layout.circleConstraint = i3;
                                        }
                                    } else {
                                        constraint.layout.verticalChainStyle = i3;
                                    }
                                } else {
                                    constraint.layout.horizontalChainStyle = i3;
                                }
                            } else {
                                constraint.layout.rightMargin = i3;
                            }
                        } else {
                            constraint.layout.orientation = i3;
                        }
                    } else {
                        constraint.layout.endMargin = i3;
                    }
                } else {
                    constraint.layout.editorAbsoluteY = i3;
                }
            } else {
                constraint.layout.editorAbsoluteX = i3;
            }
        }
        for (int i5 = 0; i5 < this.f3238f; i5++) {
            int i6 = this.f3236d[i5];
            float f = this.f3237e[i5];
            int i7 = ConstraintSet.ROTATE_NONE;
            if (i6 != 19) {
                if (i6 != 20) {
                    if (i6 != 37) {
                        if (i6 != 60) {
                            if (i6 != 63) {
                                if (i6 != 79) {
                                    if (i6 != 85) {
                                        if (i6 != 87) {
                                            if (i6 != 39) {
                                                if (i6 != 40) {
                                                    switch (i6) {
                                                        case 43:
                                                            constraint.propertySet.alpha = f;
                                                            break;
                                                        case 44:
                                                            ConstraintSet.Transform transform = constraint.transform;
                                                            transform.elevation = f;
                                                            transform.applyElevation = true;
                                                            break;
                                                        case 45:
                                                            constraint.transform.rotationX = f;
                                                            break;
                                                        case 46:
                                                            constraint.transform.rotationY = f;
                                                            break;
                                                        case 47:
                                                            constraint.transform.scaleX = f;
                                                            break;
                                                        case 48:
                                                            constraint.transform.scaleY = f;
                                                            break;
                                                        case 49:
                                                            constraint.transform.transformPivotX = f;
                                                            break;
                                                        case 50:
                                                            constraint.transform.transformPivotY = f;
                                                            break;
                                                        case 51:
                                                            constraint.transform.translationX = f;
                                                            break;
                                                        case 52:
                                                            constraint.transform.translationY = f;
                                                            break;
                                                        case 53:
                                                            constraint.transform.translationZ = f;
                                                            break;
                                                        default:
                                                            switch (i6) {
                                                                case 67:
                                                                    constraint.motion.mPathRotate = f;
                                                                    break;
                                                                case 68:
                                                                    constraint.propertySet.mProgress = f;
                                                                    break;
                                                                case 69:
                                                                    constraint.layout.widthPercent = f;
                                                                    break;
                                                                case 70:
                                                                    constraint.layout.heightPercent = f;
                                                                    break;
                                                                default:
                                                                    Log.w("ConstraintSet", "Unknown attribute 0x");
                                                                    break;
                                                            }
                                                    }
                                                } else {
                                                    constraint.layout.verticalWeight = f;
                                                }
                                            } else {
                                                constraint.layout.horizontalWeight = f;
                                            }
                                        }
                                    } else {
                                        constraint.motion.mQuantizeMotionPhase = f;
                                    }
                                } else {
                                    constraint.motion.mMotionStagger = f;
                                }
                            } else {
                                constraint.layout.circleAngle = f;
                            }
                        } else {
                            constraint.transform.rotation = f;
                        }
                    } else {
                        constraint.layout.verticalBias = f;
                    }
                } else {
                    constraint.layout.horizontalBias = f;
                }
            } else {
                constraint.layout.guidePercent = f;
            }
        }
        for (int i8 = 0; i8 < this.f3241i; i8++) {
            int i9 = this.f3239g[i8];
            String str = this.f3240h[i8];
            int i10 = ConstraintSet.ROTATE_NONE;
            if (i9 != 5) {
                if (i9 != 65) {
                    if (i9 != 74) {
                        if (i9 != 77) {
                            if (i9 != 87) {
                                if (i9 != 90) {
                                    Log.w("ConstraintSet", "Unknown attribute 0x");
                                } else {
                                    constraint.motion.mQuantizeInterpolatorString = str;
                                }
                            }
                        } else {
                            constraint.layout.mConstraintTag = str;
                        }
                    } else {
                        ConstraintSet.Layout layout = constraint.layout;
                        layout.mReferenceIdString = str;
                        layout.mReferenceIds = null;
                    }
                } else {
                    constraint.motion.mTransitionEasing = str;
                }
            } else {
                constraint.layout.dimensionRatio = str;
            }
        }
        for (int i11 = 0; i11 < this.f3244l; i11++) {
            int i12 = this.f3242j[i11];
            boolean z = this.f3243k[i11];
            int i13 = ConstraintSet.ROTATE_NONE;
            if (i12 != 44) {
                if (i12 != 75) {
                    if (i12 != 87) {
                        if (i12 != 80) {
                            if (i12 != 81) {
                                Log.w("ConstraintSet", "Unknown attribute 0x");
                            } else {
                                constraint.layout.constrainedHeight = z;
                            }
                        } else {
                            constraint.layout.constrainedWidth = z;
                        }
                    }
                } else {
                    constraint.layout.mBarrierAllowsGoneWidgets = z;
                }
            } else {
                constraint.transform.applyElevation = z;
            }
        }
    }
}
