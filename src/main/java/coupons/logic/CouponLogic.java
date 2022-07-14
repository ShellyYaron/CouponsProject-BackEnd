package coupons.logic;

import com.shelly.coupons.dao.ICouponDao;
import com.shelly.coupons.dto.Coupon;
import com.shelly.coupons.entities.CouponEntity;
import com.shelly.coupons.enums.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CouponLogic {


    private final ICouponDao couponDao;

    @Autowired
    public CouponLogic(ICouponDao couponDao) {
        this.couponDao = couponDao;
    }

    public long createCoupon(Coupon coupon) {
        CouponEntity couponEntity = new CouponEntity(coupon);
        //validations

        couponDao.save(couponEntity);
        return couponEntity.getId();
    }

    public void updateCoupon(Coupon coupon) {
        CouponEntity couponEntity = new CouponEntity(coupon);
        couponDao.save(couponEntity);
    }

    public void deleteCoupon(long id) {
        couponDao.deleteById(id);
    }

    public Coupon getCouponById(long id) {
        CouponEntity couponEntity = couponDao.findById(id).get();
        Coupon coupon = new Coupon(couponEntity);
        return coupon;
    }


    public List<Coupon> getAllCoupons() {
        List<Coupon> couponsList = new ArrayList<>();
        Iterable<CouponEntity> couponIterable = couponDao.findAll();
        for (CouponEntity couponEntity : couponIterable) {
            Coupon coupon = new Coupon(couponEntity);
            couponsList.add(coupon);
        }
        return couponsList;
    }

    public List<Coupon> getByCategory(Category category) {
        return couponDao.getByCategory(category);
    }
}