

import { Button } from "@mui/material";
import styles from "./css/Item.module.css";


export default function Item({item}){
    console.log(item);
    const {
        id,name,image_link,price,description,update_at,category,product_type,product_link
    } = item;
    return(
        <div>
            <div className={styles.wrap}>
                <div className={styles.img_item}>
                    <img src={image_link} alt={name}></img>
                </div>
                <div className={styles.info_item}>
                    <strong className={styles.tit_item}>{name}</strong>
                    <strong className={styles.num_price}>{price}</strong>
                    <span className={styles.txt_info}>
                        {category? `${category}/`:""}
                        {/* 카테고리가 비어있지 않다면 */}
                        {product_type}
                    </span>
                    <Button variant='contained' color="error">
                        구매하기
                    </Button>
                </div>
            </div>
            <div className={styles.disWrap}>
                <h3>Description</h3>
                <div style={{paddingBottom: 20, fontSize:17}}>
                    {description}
                </div>
            </div>
        </div>
    );
}