"use client";
import Image from "next/image";
import styles from "./page.module.css";
import axios from "axios";
import { useEffect, useState } from "react";
import ItemList from "@/component/ItemList";
import { Divider } from "@mui/material";



export default function Home() {
  const api_url = "/api/v1/products.json?brand=maybelline"
  const [list,setList]=useState([]);
  function callApi(){ //비동기식 통신 수행
    axios.get(api_url).then(function(res){
      //console.log(res.data);
      setList(res.data);
    })
  }

  useEffect(function(){
    callApi();
  },[]); // 빈 배열을 넣으면 1회만 수행/ 배열의 값을 넣으면 그 값이 변경될 때 호출
  return (
    <div className={styles.page}>
        <div style={{width:'80%',margin:'auto',paddingTop:'20px'}}>
          <h2>베스트상품</h2>
          <Divider/>
          {/* 구분선 */}
         
          <ItemList list={list.slice(0,8)}/>
          
          <h2>신상품</h2>
          <Divider/>
          {/* 구분선 */}
          
          <ItemList list={list.slice(8)}/>
          
        </div>
    </div>
  );
}
