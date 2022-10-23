import React, { useState, useEffect } from 'react';
import '../style/style.css';
import '../style/fonts/font.css';
import banner from '../style/img/header/banner.png';
import Sceleton from '../components/Sceleton';

const getAllDishes = 'http://localhost:8183/api/v1/dishes';
let tempOrder = [];

function Home ({dish, onClickBtnDish}) {

    const [dishes, setDishes] = useState([]);
    const [isLoading, setIsLoading] = useState(false);

    useEffect(() => {
        fetch(getAllDishes)
          .then(res => res.json())
          .then(
            (result) => {
              setDishes(result);
              setIsLoading(true);
            }
          )
      }, [])


  return (
    <>
        <section className="home-banner">
            <div className="container">                         
              <div className="block">
                  <img src={banner} alt=""/>
                  <h2>Подарок на первый заказ.</h2>
                  <p>Получите 500 рублей за подписку на рассылку</p>
                  <a href="">Подписаться</a>
              </div> 
            </div>
        </section>

        <section className="home-products">
            <div className="container">
                    <h3 className="all_products">Все товары категории</h3>
                    <div className="product-wrapper">
                    {!isLoading ? [...new Array(6)].map(() => <Sceleton/>) : dishes.map((e) => {
                        return (
                            <div className="product">
                              <div className="img">
                                  <img src={`data:image/jpg;base64, ${e.img}`} alt=""/>
                              </div>
                              <a href="" className="title">{e.name}</a>
                              <p className="description">{e.description}</p>
                              <div className="rating">
                                  <span className="active"></span>
                                  <span className="active"></span>
                                  <span className="active"></span>
                                  <span className="active"></span>
                                  <span></span>
                              </div>
                              <div className="price">
                                  <b> {e.cost} ₽/кг</b> <span>{e.weight}.</span>
                              </div>
                              <button href="" className="to-cart" onClick={() => {
                                tempOrder.push(e);
                                onClickBtnDish(tempOrder);
                                console.log(dish);
                              }}>В корзину</button>
                          </div>
                        )
                      })}
                    
                    </div>
                    <div className="pagination">
                        <nav aria-label="Page navigation example">
                            <ul className="pagination">
                             
                              <li className="page-item active"><a className="page-link" href="#">1</a></li>
                              <li className="page-item"><a className="page-link" href="#">2</a></li>
                              <li className="page-item"><a className="page-link" href="#">3</a></li>
                              <li className="page-item"><a className="page-link" href="#">4</a></li>
                              <li className="page-item"><a className="page-link" href="#">***</a></li>
                              <li className="page-item"><a className="page-link" href="#">8</a></li>
                              <li className="page-item">
                                <a className="page-link" href="#" aria-label="Next">
                                  <img src="style/img/prd/icon.jpg" alt=""/>
                                </a>
                              </li>
                            </ul>
                          </nav>
                    </div>
            </div>
        </section>

        <section className="home-video">       
                <div className="ratio ratio-16x9">
                    <iframe src="https://www.youtube.com/embed/Oopljpn9FSo" title="YouTube video" allowfullscreen>
                    </iframe>
                </div>
        </section>

        <section className="delivery">
            <div className="container">
                <div className="block">
                    <h4 className="title">
                        Бесплатная доставка по Москве и Области от 2999 RUB!
                    </h4>
                    <a href="">Оформить</a>
                </div>
            </div>
        </section>
    </>
  )
}

export default Home;