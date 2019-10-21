import React, { Component, Fragment } from 'react';
import { Header, Footer } from './Layouts'
import UserInfo from './UserInfo'

export default class extends Component {
  render() {
    return <Fragment>
      <Header/>
      <UserInfo/>
      <Footer/>
    </Fragment>
  }
}
  