package cz.itnetwork.entity.repository.specification;

import cz.itnetwork.entity.InvoiceEntity;
import cz.itnetwork.entity.InvoiceEntity_;
import cz.itnetwork.entity.filter.InvoiceFilter;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class InvoiceSpecification implements Specification<InvoiceEntity> {
    private final InvoiceFilter filter;

    @Override
    public Predicate toPredicate(Root<InvoiceEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder){
        List<Predicate> predicates = new ArrayList<>();

        if(filter.getBuyer() != null){
            predicates.add(criteriaBuilder.equal(root.get(InvoiceEntity_.BUYER), filter.getBuyer()));
        }
        if(filter.getSeller() != null){
            predicates.add(criteriaBuilder.equal(root.get(InvoiceEntity_.SELLER), filter.getSeller()));
        }
        if(filter.getProduct() != null){
            predicates.add(criteriaBuilder.like(root.get(InvoiceEntity_.PRODUCT), ("%" + filter.getProduct() + "%")));
        }
        if(filter.getMinPrice() != null){
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get(InvoiceEntity_.PRICE), filter.getMinPrice()));
        }
        if(filter.getMaxPrice() != null){
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get(InvoiceEntity_.PRICE), filter.getMaxPrice()));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }


}
