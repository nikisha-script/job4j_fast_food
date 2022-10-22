import React, { useState, useEffect } from 'react';

import './style/style.css';
import './style/fonts/font.css';

import logo from './style/img/header/full_logo.png';
import phone from './style/img/header/phone.png';
import person from './style/img/header/person.png';
import card from './style/img/header/shopping-cart.png';
import banner from './style/img/header/banner.png';

const getAllCategories = 'http://localhost:8183/api/v1/categories';
const getAllDishes = 'http://localhost:8183/api/v1/dishes';
let tempOrder = [];

function App() {

  const [categories, setCategories] = useState([]);
  const [dishes, setDishes] = useState([]);
  const [orders, setOrders] = useState([]);
  const [orderCount, setOrderCount] = useState(0);
 
  useEffect(() => {
    fetch(getAllCategories)
      .then(res => res.json())
      .then(
        (result) => {
          setCategories(result);
        }
      )
  }, [])

  useEffect(() => {
    fetch(getAllDishes)
      .then(res => res.json())
      .then(
        (result) => {
          setDishes(result);
        }
      )
  }, [])



  return (
    <div className="wrapper">
        <header>
            <nav className="navbar navbar-expand-lg bg-light">
                <div className="container">
                  <a className="navbar-brand" href="index.html">
                    <img src={logo} alt="#"/>
                  </a>
                  <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                  </button>
                  <div className="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul className="navbar-nav me-auto mb-2">
                      <li className="nav-item dropdown">
                            <a className="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                              Меню
                            </a>
                            <div className="dropdown-menu">
                              {categories.map(e => {
                                return(
                                  <a className="dropdown-item" href="#">
                                    <span><img src={`data:image/jpg;base64, ${e.img}`}/></span> 
                                      {e.name}
                                  </a>
                                )
                              })};
                         
                            </div>
                      </li>
                      <li className="nav-item">
                        <a className="nav-link" href="page.html">Доставка</a>
                      </li>
                      <li className="nav-item">
                        <a className="nav-link" href="#">Оплата</a>
                      </li>
                      <li className="nav-item">
                        <a href="booking.html" className="nav-link">Поддержка</a>
                      </li>
                    </ul>
                    
                    <div className="menu-right d-flex">
                        <div className="menu-contact">
                            <a href="tel: +78312826000">
                                <img src={phone} alt=""/>
                                <span>+7 (831) 282-60-00</span>
                            </a>
                        </div>
                        <div className="menu-user">
                            <button className="profile" data-bs-toggle="modal" data-bs-target="#login">
                                <img src={person} alt="#"/>
                            </button>
                            <a className="cart" href="#">
                                <img src={card} alt=""/>
                                  {orderCount !== 0 && (
                                    <span>{orderCount}</span>
                                  )}
                            </a>
                        </div>
                    </div>
                  </div>
                </div>
              </nav>
        </header>

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
                      {dishes.map(e => {
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
                                setOrders(tempOrder);
                                setOrderCount(orderCount + 1);
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

        <footer>
            <div className="container">
                <div className="footer-wrapper">
                    <div className="footer-left">
                        <div className="phones">
                            <div className="phone-item">
                                <span>Бесплатный звонок по РФ</span>
                                <a href="tel:+78312826000">+7 (831) 282-60-00</a>
                            </div>
                            <div className="phone-item">
                                <span>Для приема заказов</span>
                                <a href="tel:+79040664685">+7 (904) 066-46-85</a>
                            </div>
                        </div>
                        <div className="work-time">
                            График работы по будням с 9:00 до 18:00
                        </div>
                        <div className="work-email">
                            <a href="mailto: danya.nikisha@mail.ru">Email: danya.nikisha@mail.ru</a>
                            <a href="" className="site-help">Поддержка</a>
                        </div>
                    </div>
                    <div className="footer-center">
                        <div className="social">
                            <a href="https://vk.com/d.nikishin" target="_blank">Мы в вконтакте</a>
                        </div>
                    </div>
                    <div className="footer-right">
                        <div className="person">
                            <a href="" data-bs-toggle="modal" data-bs-target="#reg"><img src="style/img/prd/person.png" alt=""/><span>Войти / Регистрация</span></a>
                        </div>
                    </div>
                    
                </div>
                <div className="footer_bottom">
                    <span>©2020. Пиросмани</span>
                    <a href="">Условия и соглашения</a>
                    <a href="">Политика конфиденциальности</a>
                </div>
            </div>
        </footer>

    </div>
  );
}
 
export default App;
