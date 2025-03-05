import { Grid2 } from "@mui/material";
import styles from "./css/itemList.module.css";
import Link from "next/link";




export default function ItemList({list}){ 
    // 꼭 필요한 인자를 받아야한다면 중괄호로 묶는다.
    // 이 경우에는 아래에서 그냥 찍힌다 원래는 list.list.해야함.
    console.log(list);
    return(
        <div>
            <Grid2 container>
             
                {list.map((item,i)=> (
                    <Grid2 item size={{xs:3}} key={item.id}>
                         <Link href="/views[id]" as={`/views/${item.id}`}>
                         {/* as 안의 값을 넣어서 보낸다 */}
                             <div className={styles.wrap}>
                                <img src={item.image_link} alt ={item.name} className={styles.img_item}/>
                                <div>
                                    <p  className={styles.title_item}>{item.name}</p>
                                    <div>
                                        <span className={styles.txt_info}>{item.category} &nbsp; {item.product_type}</span>
                                    </div>
                                    <p  className={styles.num_price}>${item.price}</p>
                                </div>
                              </div>
                          </Link>
                    </Grid2>

                ))}

            </Grid2>
        </div>
    );
}